package ru.job4j.grabber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

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
            list.add(detail(nextLink));
        }
        return list;
    }

    @Override
    public Post detail(String link) {
        Document doc = null;
        String description = null;
        String date = null;
        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = null;
        if (doc != null) {
            title = doc.select(".messageHeader").get(0).text();

            description = doc.select(".msgBody").get(1).text();
            date = doc.select(".msgFooter").first().text().split(" \\[")[0];
        }
        LocalDateTime created = dateTimeParser.parse(date);
        return new Post(title, link, description, created);
    }
}
