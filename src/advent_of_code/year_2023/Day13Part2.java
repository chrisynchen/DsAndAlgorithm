package advent_of_code.year_2023;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day13Part2 {
    public static void main(String[] args) {
        Path path = Paths.get("src/advent_of_code/year_2023/test_data/day13part2.txt");
        String[] arr = null;
        try {
            final List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
            arr = lines.toArray(new String[lines.size()]);
            long start = System.currentTimeMillis();
            System.out.println(solve(arr));
            long runTime = System.currentTimeMillis() - start;
            System.out.println("Run Time: " + (runTime));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static long solve(String[] examples) {
        long result = 0;

        int prevIndex = 0;
        for (int i = 0; i < examples.length; i++) {
            final String line = examples[i];
            if (line.isEmpty()) {
                int n = examples[prevIndex].length();
                int m = i - prevIndex;
                final long[] rows = new long[m];
                final long[] cols = new long[n];
                for (int j = 0; j < m; j++) {
                    String s = examples[j + prevIndex];
                    for (int k = 0; k < n; k++) {
                        if (s.charAt(k) == '#') {
                            rows[j] |= (1L << k);
                            cols[k] |= (1L << j);
                        }
                    }
                }

                boolean valid = false;
                long prevResult = partOneAns(rows, cols);
                for (int x = 0; x < m; x++) {
                    long first = rows[x];
                    for (int y = x + 1; y < m; y++) {
                        long second = rows[y];
                        long diff = Math.abs(first - second);
                        if ((diff & (diff - 1)) == 0) {
                            if (rows[x] > rows[y]) {
                                long temp = rows[x];
                                rows[x] = rows[y];
                                if(prevResult == partOneAns(rows, cols)) {
                                    rows[x] = temp;
                                    rows[y] = temp;
                                }
                            } else {
                                long temp = rows[y];
                                rows[y] = rows[x];
                                if(prevResult == partOneAns(rows, cols)) {
                                    rows[x] = temp;
                                    rows[y] = temp;
                                }
                            }
                            valid = true;
                            break;
                        }
                    }
                    if (valid) break;
                }
                if (!valid) {
                    for (int x = 0; x < n; x++) {
                        long first = cols[x];
                        for (int y = x + 1; y < n; y++) {
                            long second = cols[y];
                            long diff = Math.abs(first - second);
                            if ((diff & (diff - 1)) == 0) {

                                if (cols[x] > cols[y]) {
                                    long temp = cols[x];
                                    cols[x] = cols[y];
                                    if(prevResult == partOneAns(rows, cols)) {
                                        cols[x] = temp;
                                        cols[y] = temp;
                                    }
                                } else {
                                    long temp = cols[y];
                                    cols[y] = cols[x];
                                    if(prevResult == partOneAns(rows, cols)) {
                                        cols[x] = temp;
                                        cols[y] = temp;
                                    }
                                }
                                valid = true;
                                break;
                            }
                        }
                        if (valid) break;
                    }
                }

                int rResult = 0;
                for (int j = 0; j < m - 1; j++) {
                    int a = j;
                    int b = j + 1;
                    while (a >= 0 && b < m) {
                        if (rows[a] != rows[b]) {
                            break;
                        }
                        a--;
                        b++;
                    }
                    if (b == m || a == -1) {
                        rResult = Math.max(rResult, j + 1);
                    }
                }

                int cResult = 0;
                for (int j = 0; j < n - 1; j++) {
                    int a = j;
                    int b = j + 1;
                    while (a >= 0 && b < n) {
                        if (cols[a] != cols[b]) {
                            break;
                        }
                        a--;
                        b++;
                    }
                    if (b == n || a == -1) {
                        cResult = Math.max(cResult, j + 1);
                    }
                }
                if(valid) {
                    result += (rResult * 100);
                } else {
                    result += cResult;
                }
//                result += (rResult * 100) + cResult;
                prevIndex = i + 1;
            }
        }

        return result;
    }

    private static long partOneAns(long[] rows, long[] cols) {
        long result = 0;
        int n = cols.length;
        int m = rows.length;

        int rResult = 0;
        for (int j = 0; j < m - 1; j++) {
            int a = j;
            int b = j + 1;
            while (a >= 0 && b < m) {
                if (rows[a] != rows[b]) {
                    break;
                }
                a--;
                b++;
            }
            if (b == m || a == -1) {
                rResult = Math.max(rResult, j + 1);
            }
        }

        int cResult = 0;
        for (int j = 0; j < n - 1; j++) {
            int a = j;
            int b = j + 1;
            while (a >= 0 && b < n) {
                if (cols[a] != cols[b]) {
                    break;
                }
                a--;
                b++;
            }
            if (b == n || a == -1) {
                cResult = Math.max(cResult, j + 1);
            }
        }

        result += (rResult * 100) + cResult;

        return result;
    }

    //22100 too low
}
