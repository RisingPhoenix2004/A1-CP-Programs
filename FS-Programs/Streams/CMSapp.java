/*
 * You are given a list of Article objects. Each Article has three fields:
	int articleID – a unique identifier
	String authorName – the name of the article’s author
	int wordCount – the number of words in that article

Task: Write a Java program that:
	1. Computes the average word count for each author across all their articles.
	2. Determines which author has the highest average word count.
	3. Prints the author’s name along with their average word count (formatted to two decimal places).

	If there are no articles, the program should print “No data available.”
	
Expected Output:
----------------
Top author: Alice Smith (avg words: 636.67)
 */
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CMSapp {
    public static void main(String[] args) {
        List<Article> articles = List.of(
            new Article(101, "Alice Smith",   520),
            new Article(102, "Bob Johnson",   330),
            new Article(103, "Alice Smith",   780),
            new Article(104, "Carol Davis",   450),
            new Article(105, "Bob Johnson",   620),
            new Article(106, "Alice Smith",   610)
        );

        Optional<Map.Entry<String, Double>> ta = articles.stream()
            .collect(Collectors.groupingBy(Article::getAuthorName, Collectors.averagingInt(Article::getWordCount)))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue());
        ta.ifPresent(entry -> 
            System.out.printf("Top author: %s (avg words: %.2f)%n", entry.getKey(), entry.getValue())
        );
    }
}
class Article {
    private final int articleID;
    private final String authorName;
    private final int wordCount;
    public Article(int articleID, String authorName, int wordCount) {
        this.articleID = articleID;
        this.authorName = authorName;
        this.wordCount = wordCount;
    }
    public String getAuthorName() {
        return authorName;
    }
    public int getWordCount() {
        return wordCount;
    }
}