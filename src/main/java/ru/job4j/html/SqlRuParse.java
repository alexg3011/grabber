package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 5; i++) {
            Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/" + i).get();
            Elements row = doc.select(".postslisttopic");
            for (Element td : row) {
                Element element = td.parent().children().get(5);
                DateTimeParser dateTimeParser = new SqlRuDateTimeParser();
                if (!td.parent().children().get(5).hasAttr("Текст")) {
                    System.out.println(dateTimeParser.parse(element.text()));
                }
            }
        }
    }
}