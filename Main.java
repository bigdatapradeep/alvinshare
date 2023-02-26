import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println("Hello world!");
        copyUsingJavaStreams();
    }
    private static void copyUsingJavaStreams() throws IOException {
//        Boolean isHeader=false;
//        if(isHeader)
        String delimiter=",";

        String source="D:\\bigdata_set\\in\\data10.txt";
        String target="D:\\bigdata_set\\out\\data1.txt";
        try (
                InputStream inputStream = new FileInputStream(source);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));

                FileWriter fileWriter = new FileWriter(target, false);
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWriter));

                Stream<String> linesStream = bufferedReader.lines().skip(1);
        ) {
            Instant start=  Instant.now();
            linesStream.forEach(
                    line -> {
//                        if (!line.isEmpty()) {



//                        List<String> items = new ArrayList<String>(Arrays.asList(line.split("\\,+")));
//                        items.add(items.get(0).toString().toUpperCase());
////                        System.out.println(items.stream().collect(Collectors.joining(",")));
//                        printWriter.println( String.join(",", items));

                        List ss=Arrays.stream(line.split("\\\\+delimiter+\\+")).collect(Collectors.toList());
//                        List ss=Arrays.stream(line.split("\\,+")).collect(Collectors.toList());

                            if(ss.get(0).toString().length()>0) {
                                ss.add(ss.get(0).toString().toUpperCase());
                                System.out.println(String.join(delimiter, ss));
                                printWriter.println(String.join(",", ss));
                            }else{
                                System.out.println(String.join(delimiter, ss));
                                printWriter.println(String.join(",", ss));
                            }

//                    }  //line empty
                    }
            );
            Instant end=  Instant.now();
            System.out.println(Duration.between(start, end).toMillis());
            System.out.println(Duration.between(start, end).toSeconds());
            System.out.println(Duration.between(start, end).toMinutes());

//            linesStream.forEach(printWriter::println);
        }



    }

    private static void addColumn(List ss) {
        ss.add(ss.get(0).toString().toUpperCase());
    }
    /**
     * Gets the element in the given list with the given index,
     * or null if the list is null or if the index is outside the range
     * or if the value at the given index is null.
     */
    public static <T> T getOrNull(List<T> c, int index) {
        if (c == null)
            return null;
        if (index < 0 || index >= c.size())
            return null;
        return c.get(index);
    }
}