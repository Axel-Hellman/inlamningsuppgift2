package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import model.Factory;
import model.Cell;

//TODO move to another package
public class XLBufferedReader extends BufferedReader {
	
	private Factory factory = new Factory();
	
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate
    public void load(Map<String, Cell> map) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                String name = string.substring(0, i);
                String expr = string.substring(i+1);
                map.put(name, factory.cell(expr));
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
