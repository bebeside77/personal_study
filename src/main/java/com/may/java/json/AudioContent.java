package com.may.java.json;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AudioContent {
	private String contentsId;
	private String title;
	private List<Metadata> metadata = new ArrayList<>();
}
