package rayboc.rayboc.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogFileUtil {

	private static final String ACCESS_TOKEN_KEY = "ATK=";

	/**
	 * 故障キーワードに該当する行からアクセストークンのリスト取得
	 * 
	 * @param filePath
	 * @return アクセストークンのリスト
	 */
	public static List<String> getATKList(String filePath, String keyword) {

		List<String> atkList = new ArrayList<String>();

		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			atkList = stream.filter(atk -> atk.contains(keyword))
					.map(atk -> atk.substring(atk.indexOf(ACCESS_TOKEN_KEY) + 4, atk.indexOf(ACCESS_TOKEN_KEY) + 40))
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		atkList.forEach(atk -> {
			System.out.println("getATKList " + keyword + ": " + atk);
		});

		return atkList;
	}

	/**
	 * 故障キーワードのアクセストークンに一致する行をカウントする
	 * @param filePath
	 * @param collaboAtkList
	 * @param largeFauilureAtkList
	 * @return
	 */
	public static List<String> countFailurKey(String filePath, List<String> collaboAtkList, List<String> largeFauilureAtkList) {

		List<String> keyList = collaboAtkList.stream()
				.filter(collaboAtk -> largeFauilureAtkList.contains(collaboAtk))
				.collect(Collectors.toList());
		
		keyList.forEach(key -> System.out.println("keyList: " + key));
		
		return keyList;

	}
	
}
