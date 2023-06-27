package com.spring.shortenURL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShortenUrlApplication {


	public class URLShortener {

		private static final String BASE52_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		private HashMap<Integer, String> urlMapping = new HashMap<>();

		public String getShortUrl(int id) {
			StringBuilder shortUrl = new StringBuilder();
			while (id > 0) {
				shortUrl.insert(0, BASE52_ALPHABET.charAt(id % BASE52_ALPHABET.length()));
				id /= BASE52_ALPHABET.length();
			}
			return shortUrl.toString();
		}

		public String getOriginalUrl(String shortUrl) {
			int id = 0;
			for (char c : shortUrl.toCharArray()) {
				id = id * BASE52_ALPHABET.length() + BASE52_ALPHABET.indexOf(c);
			}
			return urlMapping.get(id);
		}

		public void storeOriginalUrl(int id, String originalUrl) {
			urlMapping.put(id, originalUrl);
		}

		public static void main(String[] args) {
			URLShortener urlShortener = new URLShortener();

			String originalUrl1 = "https://www.example.com/some_url1";
			String originalUrl2 = "https://www.example.com/some_url2";

			int id1 = urlShortener.urlMapping.size() + 1;
			urlShortener.storeOriginalUrl(id1, originalUrl1);
			String shortUrl1 = urlShortener.getShortUrl(id1);

			int id2 = urlShortener.urlMapping.size() + 1;
			urlShortener.storeOriginalUrl(id2, originalUrl2);
			String shortUrl2 = urlShortener.getShortUrl(id2);

			System.out.println("Short URL for originalUrl1: " + shortUrl1);
			System.out.println("Short URL for originalUrl2: " + shortUrl2);

			System.out.println("URL restored from shortUrl1: " + urlShortener.getOriginalUrl(shortUrl1));
			System.out.println("URL restored from shortUrl2: " + urlShortener.getOriginalUrl(shortUrl2));
		}
	}
