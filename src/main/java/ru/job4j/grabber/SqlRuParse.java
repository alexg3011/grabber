package ru.job4j.grabber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.Post;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {

    private final DateTimeParser dateTimeParser;

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public List<Post> list(String link) throws IOException {
        List<Post> list = new ArrayList<>();
        Document doc = Jsoup.connect(link).get();
        Elements row = doc.select(".postslisttopic");
        for (Element td : row) {
            String nextLink = td.child(0).attr("href");
            Post post = detail(nextLink);
            if (post != null) {
                list.add(post);
            }
        }
        return list;
    }

    @Override
    public Post detail(String link) {
        Post post = null;
        Document doc = null;
        String description;
        String date;
        String title;

        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (doc != null) {
            title = doc.select(".messageHeader").get(0).text();
            String verify = title.toLowerCase();
            if (verify.contains("java") && !verify.contains("javascript")) {
                description = doc.select(".msgBody").get(1).text();
                date = doc.select(".msgFooter").first().text().split(" \\[")[0];
                LocalDateTime created = dateTimeParser.parse(date);
                post = new Post(title, description, link, created);
            }
        }
        return post;
    }
}
