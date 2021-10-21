package ru.job4j.grabber.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.Map;

public class SqlRuDateTimeParser implements DateTimeParser {

    private static final Map<String, String> MONTHS = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("янв", "01"),
            new AbstractMap.SimpleEntry<>("фев", "02"),
            new AbstractMap.SimpleEntry<>("мар", "03"),
            new AbstractMap.SimpleEntry<>("апр", "04"),
            new AbstractMap.SimpleEntry<>("май", "05"),
            new AbstractMap.SimpleEntry<>("июн", "06"),
            new AbstractMap.SimpleEntry<>("июл", "07"),
            new AbstractMap.SimpleEntry<>("авг", "08"),
            new AbstractMap.SimpleEntry<>("сен", "09"),
            new AbstractMap.SimpleEntry<>("окт", "10"),
            new AbstractMap.SimpleEntry<>("ноя", "11"),
            new AbstractMap.SimpleEntry<>("дек", "12")
    );

    @Override
    public LocalDateTime parse(String parse) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yy HH:mm");
        parse = parse.replace(",", "");
        if (parse.contains("сегодня")) {
            parse = parse.replace("сегодня", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MM yy")));

        } else if (parse.contains("вчера")) {
            parse = parse.replace("вчера", LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("dd MM yy")));
        } else {

            String[] tmp = parse.split(" ");
            tmp[1] = MONTHS.get(tmp[1]);
            parse = String.join(" ", tmp);
        }

        return LocalDateTime.parse(parse, formatter);
    }

    public static Post readPost(String link) throws IOException {
        Post post = new Post();
        SqlRuDateTimeParser parser = new SqlRuDateTimeParser();
        Document doc = Jsoup.connect(link).get();
        String description = doc.select(".msgBody").get(1).text();
        String date = doc.select(".msgFooter").first().text().split(" \\[")[0];
        LocalDateTime created = parser.parse(date);

        return new Post(description, created);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readPost(
                "https://www.sql.ru/forum/1325330/lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t")
                .getDescription());
    }
}