package com.pacificisland;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Islands {

	private static final char ISLAND_SYM = '*';

	private static final char SEA_SYM = '~';

	private byte[][] area;
	
	private LinkedList<Vertex> stack = new LinkedList<>();
	
	private String inputFileName;
	
	private int islandsCount;
	
	Islands() {
		inputFileName = "input.txt";
	}
	
	Islands(String inputFileName) {
		this.inputFileName = inputFileName;
	}


	public static void main(String[] args) {
		Islands islands = new Islands();
		try {
			islands.read();
		} catch (IOException e) {
			System.err.println("read input file error");
			System.exit(1);
		} catch (IllegalInputDataException e) {
			System.err.println("format input file error");
			System.exit(1);
		}
		System.out.println(islands.count());
	}
	
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	
	public String getInputFileName() {
		return inputFileName;
	}

	public void read() throws IOException, IllegalInputDataException {
		Path file = Paths.get(inputFileName);
		try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.US_ASCII)) {
			String line = reader.readLine();
			String[] areaSizes = line.split(" ");
			int n = Integer.valueOf(areaSizes[0]);
			int m = Integer.valueOf(areaSizes[1]);
			area = new byte[n + 2][m + 2];
			int i = 1;
			while ((line = reader.readLine()) != null) {
				int j = 1;
				for (char sym : line.toCharArray()) {
					if (sym == ISLAND_SYM) {
						area[i][j] = 1;
					} else if (sym != SEA_SYM) {
						throw new IllegalInputDataException();
					}
					++j;
				}
				++i;
			}
		} catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
			throw new IllegalInputDataException();
		}
	}
	
	private int countDfs(Vertex sourceVertex) {
		
		stack.push(sourceVertex);
		
		int counter = 0;
		
		while (!stack.isEmpty()) {
			
			Vertex vertex = stack.pop();
			int x = vertex.getX();
			int y = vertex.getY();
			
			if (area[x][y] != 0) {
				
				++counter;
				
				area[x][y] = 0;
				
				if (area[x][y - 1] != 0) {
					stack.push(new Vertex(x, y - 1));
				}

				if (area[x][y + 1] != 0) {
					stack.push(new Vertex(x, y + 1));
				}
				
				if (area[x + 1][y] != 0) {
					stack.push(new Vertex(x + 1, y));
				}


				if (area[x - 1][y] != 0) {
					stack.push(new Vertex(x - 1, y));
				}

			}
			
		}
		
		return counter;
		
	}
	
	
	public int count() {
		
		if (area == null) {
			return islandsCount;
		}
		
		islandsCount = 0;
		
		int n = area.length - 1;
		int m = area[0].length - 1;
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (area[i][j] != 0 && countDfs(new Vertex(i, j)) > 1) {
					++islandsCount;
				}
			}
		}
		
		area = null;
		
		return islandsCount;		
	}
	
    private class Vertex {
    	private final int x;
    	private final int y;
    	
    	Vertex(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    	
    	int getX() {
    		return x;
    	}
    	
    	int getY() {
    		return y;
    	}
    	
    }

}
