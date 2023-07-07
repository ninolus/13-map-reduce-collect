package ohm.softa.a13.tweets.generators;

import com.google.gson.Gson;
import ohm.softa.a13.model.Tweet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.stream.Stream;

public class OfflineTweetStreamGenerator implements TweetStreamGenerator {
	Gson gson = new Gson();
	String TWEETS_FILE = "/trump_tweets.json";

	@Override
	public Stream<Tweet> getTweetStream() {
		try (InputStream tweetInputStream = getClass().getResourceAsStream(TWEETS_FILE)) {
			Reader reader = new InputStreamReader(tweetInputStream);
			Tweet[] tweets = gson.fromJson(reader, Tweet[].class);
			return Arrays.stream(tweets);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
