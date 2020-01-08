import vn.pipeline.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordSegmentation {

	public static void main(String[] args) throws IOException {
		// 0. The directories
		String input_dir = "../NON-TECH_input_texts/";
		String output_dir = "../NON-TECH_output_texts/";
		
		// 1. Initialize a Pipeline
		String[] annotators = {"wseg"};
		VnCoreNLP pipeline = new VnCoreNLP(annotators);

		// 2A. List all files in "input_dir"
		File folder = new File(input_dir);
		File[] listOfFiles = folder.listFiles();

		// 2B. Browse-thru the list of files. 
		//     Segment each of it. Then write to output_dir.
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        segmentADoc(file.getPath(), output_dir + file.getName(), pipeline);
		    }
		}
	}
	
	private static void segmentADoc(String input_path, String output_path, 
									VnCoreNLP pipeline) throws IOException {
		// 1. Read "input_path" to get text
		byte[] encoded = Files.readAllBytes(Paths.get(input_path));
		String text = new String(encoded, StandardCharsets.UTF_8);

		// 2. Use the pipeline to segment the text
		Annotation annotation = new Annotation(text);
		pipeline.annotate(annotation);

		// 3A. Get all segments as an ArrayList
		// 3B. Write to "output_path"
		List<String> segments = getSegments(annotation);
		Files.write(Paths.get(output_path), segments, StandardCharsets.UTF_8);
	}
	
	private static List<String> getSegments(Annotation annotation) {
		List<String> results = new ArrayList<>();
		
		List<Sentence> sentences = annotation.getSentences();
        List<Word> words;
        for(Sentence sentence : sentences) {
        	words = sentence.getWords();
        	for(Word word: words) {
        		results.add(word.getForm().toLowerCase());
        	}
        }
        
		return results;
	}

}
