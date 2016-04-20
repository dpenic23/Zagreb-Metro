package hr.fer.zgmetro.model;

import java.util.List;

public class Path {
	
	List<String> path;
	
	public Path (List<String> path)	{
		this.path = path;
	}
	
	@Override
	public String toString()	{
		StringBuilder sb = new StringBuilder();
		for(String s : path)	{
			sb.append(s);
			sb.append("-");
		}
		sb.deleteCharAt(sb.length()-1);
		
		return sb.toString();
	}

	public List<String> getPath() {
		return path;
	}
}
