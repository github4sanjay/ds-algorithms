package recurssion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePaths {

    public static void main(String[] args) {
        // [hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
        System.out.println(get(1,1, 3,3));
        justPrint(1,1,3,3, "");
        // [h1h1v1v1, h1h1v2, h1v1h1v1, h1v1v1h1, h1v1d1, h1v2h1, h1d1v1, h2v1v1, h2v2, v1h1h1v1, v1h1v1h1, v1h1d1, v1h2v1, v1v1h1h1, v1v1h2, v1d1h1, v2h1h1, v2h2, d1h1v1, d1v1h1, d1d1, d2]
        System.out.println(getWithJumps(1,1, 3,3));
        justPrintWithJumps(1,1,3,3, "");
    }

    private static List<String> get(int sourceRow, int srcCol, int desRow, int desCol) {
        if (sourceRow == desRow && srcCol == desCol){
            var initialList = new ArrayList<String>();
            initialList.add("");
            return initialList;
        } else if (sourceRow > desRow){
            return new ArrayList<>();
        } else if (srcCol > desCol){
            return new ArrayList<>();
        }

        List<String> rowList = get(sourceRow + 1, srcCol, desRow, desCol);
        List<String> colList = get(sourceRow, srcCol + 1, desRow, desCol);
        var finalList = new ArrayList<String>();
        for (String path : rowList){
            finalList.add("h" + path);
        }

        for (String path : colList){
            finalList.add("v" + path);
        }
        return finalList;
    }

    private static void justPrint(int sourceRow, int srcCol, int desRow, int desCol, String answer) {
        if (sourceRow == desRow && srcCol == desCol){
            System.out.println(answer);
            return;
        } else if (sourceRow > desRow){
            return ;
        } else if (srcCol > desCol){
            return;
        }

        justPrint(sourceRow + 1, srcCol, desRow, desCol, "h" + answer);
        justPrint(sourceRow, srcCol + 1, desRow, desCol, "v" + answer);
    }

    private static List<String> getWithJumps(int sourceRow, int srcCol, int desRow, int desCol) {
        if (sourceRow == desRow && srcCol == desCol){
            var initialList = new ArrayList<String>();
            initialList.add("");
            return initialList;
        } else if (sourceRow > desRow){
            return new ArrayList<>();
        } else if (srcCol > desCol){
            return new ArrayList<>();
        }

        var finalList = new ArrayList<String>();
        for (int i = 1; i <= desCol - srcCol; i++){
            List<String> rowList = getWithJumps(sourceRow, srcCol + i, desRow, desCol);
            for (String path : rowList){
                finalList.add("h" + i + path);
            }
        }


        for (int i = 1; i <= desRow - sourceRow; i++){
            List<String> colList = getWithJumps(sourceRow + i, srcCol , desRow, desCol);
            for (String path : colList){
                finalList.add("v" + i + path);
            }
        }

        for (int i = 1; i < Math.min(desRow, desCol); i++){
            List<String> diaList = getWithJumps(sourceRow + i, srcCol + i, desRow, desCol);
            for (String path : diaList){
                finalList.add("d" + i + path);
            }
        }

        return finalList;
    }

    private static void justPrintWithJumps(int sourceRow, int srcCol, int desRow, int desCol, String answer) {
        if (sourceRow == desRow && srcCol == desCol){
            System.out.println(answer);
            return;
        } else if (sourceRow > desRow){
            return ;
        } else if (srcCol > desCol){
            return;
        }

        for (int i = 1; i <= desCol - srcCol; i++){
            justPrintWithJumps(sourceRow, srcCol + i, desRow, desCol,"h" + i + answer);
        }


        for (int i = 1; i <= desRow - sourceRow; i++){
            justPrintWithJumps(sourceRow + i, srcCol , desRow, desCol, "v" + i + answer);
        }

        for (int i = 1; i < Math.min(desRow, desCol); i++){
            justPrintWithJumps(sourceRow + i, srcCol + i, desRow, desCol, "d" + i + answer);
        }
    }
}
