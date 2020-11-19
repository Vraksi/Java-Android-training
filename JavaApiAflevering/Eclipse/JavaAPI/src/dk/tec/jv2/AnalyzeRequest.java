package dk.tec.jv2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzeRequest {
	
	MatchEnum level;
	int id;

	public AnalyzeRequest(String pathInfo) 
	{
		
		Matcher matcher = Pattern.compile("(?i)^/Person/([0-9]+)$").matcher(pathInfo);
		if(matcher.find()) {
			level = MatchEnum.MatchPersonId;
			id = Integer.parseInt(matcher.group(1));
		}
		else {
			matcher = Pattern.compile("(?i)^/Person/?$").matcher(pathInfo);
			if (matcher.find()) {
				level = MatchEnum.MatchPerson;
			}
			else
			{
				level = MatchEnum.MatchNo;
			}
		}
	}

	
	
	
	
	public MatchEnum getLevel()
	{
		return level;
	}
	
	public int getId() 
	{
		return id;
	}
}
