package jp.michikusa.chitose.doclet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DocletOption
{
    public static int getOptionLength(String option)
    {
	String[] options = {"-d", "-bottom", "-author", "-charset", "-windowtitle", "-header", "-footer", "-top", "-link", "-docencoding", "-doctitle"};
		for( String str : options){
        if(str.equals(option))
        {
            return 2;
        }
		} 
		
	String[] options2 = {"-use", "-append", "-pretty", "-version"};
		for( String str : options2){
        if(str.equals(option))
        {
            return 1;
        }
		}
		if ("-linkoffline".equals(option)){
			return 3;
		}
        
            return 0;
		
    }

    public DocletOption(String[][] options)
    {
        for(final String[] pair : options)
        {
           if("-d".equals(pair[0]))
            {
                this.outputFilename = new File( pair[1]+"\\all_data.json");
		
            } else 
            if("-append".equals(pair[0]))
            {
                this.appendMode = true;
            }
            else if("-pretty".equals(pair[0]))
            {
                this.pretty = true;
            }
        }

    }

    public OutputStream openOutputStream()
        throws IOException
    {
        return new FileOutputStream(this.outputFilename, true);
    }

    public boolean isPretty()
    {
        return this.pretty;
    }

    private File outputFilename;

    private boolean appendMode;

    private boolean pretty;
}
