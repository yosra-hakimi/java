package ex_3_2_4;

/*
import java.io.*;

public class ListerRepertoire {
    
    public static void main(String args[]) {
    	
        File repertoire = new File("C://Users//yhakimi//Desktop//yosrahakimi");
        String liste[] = repertoire.list();      
 
        if (liste != null) {         
            for (int i = 0; i < liste.length; i++) {
                System.out.println(liste[i]);
            }
        } else {
            System.err.println("Nom de repertoire invalide");
        }
    }
}

*/
/*
import java.io.File;

public class ListerRepertoire
{
    public static void main(String[] args)
    {
        File folder = new File("C://Users//yhakimi//Desktop//yosrahakimi");
 
        String[] files = folder.list();
 
        for (String file : files)
        {
            System.out.println(file);
        }
    }
}
*/
/*
import java.io.File;

public class ListerRepertoire
{
    private static void listFiles(String path)
    {
        File folder = new File(path);
 
        File[] files = folder.listFiles();
 
        for (File file : files)
        {
            if (file.isFile())
            {
                System.out.println(file.getName());
            }
            else if (file.isDirectory())
            {
                listFiles(file.getAbsolutePath());
                System.out.println(file.getName());
            }
        }
    }
 
    public static void main(String[] args)
    {
        listFiles("C://Users//yhakimi//Desktop//yosrahakimi");
    }
}



*/


/*
import java.io.File;
import java.io.FilenameFilter;

public class ListerRepertoire {
    private static final String PATH = "C://Users//yhakimi//Desktop//yosrahakimi";

    public static void main(String[] args) {
        File directory = new File(PATH);
        File[] fileList = directory.listFiles(new MyFilter());

        for (File file : fileList) System.out.println(file.getName());
    }

}

class MyFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".java");
    }
}
*/


/*
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class ListerRepertoire {

	public static void main(String[] args) throws IOException {

		File f = new File("C://Users//yhakimi//Desktop//yosrahakimi"); // current directory

		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				String lowercaseName = name.toLowerCase();
				if (lowercaseName.endsWith(".txt")) {
					return true;
				} else {
					return false;
				}
			}
		};

		File[] files = f.listFiles(textFilter);
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.print("directory:");
			} else {
				System.out.print("     file:");
			}
			System.out.println(file.getCanonicalPath());
		}

	}

}
*/


