import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainExists {
    public static void main(String[] args) {
        Map<String, Integer> lottoNumCountMap = new HashMap<String, Integer>();
        int i = 1;
        String firstPageContents; ///
        int totalNum = Integer.MAX_VALUE;
        String pageCheckString = "Total <span>";
        long sumLottoPrice = 0;
        long currLottoPrice = 0;
        int numOfWinner = 0;
        while (i <= totalNum) {
            try {
                File file = new File("hello1"); //  저장할 파일 생성
                String url = "https://www.fullayer.com/lottowinnumber/fo/lottowinnumberlist?s_pagenum=" + i;

                URL urlObj = new URL(url);
                URLConnection conn = urlObj.openConnection();
                InputStream is = conn.getInputStream();

                byte[] bf = new byte[1024];
                ByteArrayOutputStream out = new ByteArrayOutputStream();

                int cnt = -1;

                while ((cnt = is.read(bf)) != -1) {
                    out.write(bf, 0, cnt);
                }

                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write(new String(out.toByteArray()));

                FileReader fileReader = new FileReader(file);

                BufferedReader br = new BufferedReader(fileReader);

                String str;
                String regNondigits = "[^0-9]";
//                String regNondigits = "\\D+";
                int count = 1;
                boolean isBeforeWon = false;
                while ((str = br.readLine()) != null) {
                    //// 0. 페이지 구하기
                    if(i == 1 && str.contains(pageCheckString)) {
                        firstPageContents = str.substring(str.indexOf(pageCheckString)+pageCheckString.length());
//                        totalNum = Integer.parseInt(firstPageContents.substring(0, firstPageContents.indexOf("</span>")).replaceFirst(",", ""));
                        totalNum = 2;
                        System.out.println("totalNum : " + totalNum);
                    }

                    //// 1. 로또 당첨자 수
                    String startString = "<td class=\"center vmiddle\">";
                    String endString = "</td>";
                    if(str.contains(startString) && str.contains(endString)){
                        int startIdx = str.indexOf(startString);
                        int endIdx = str.indexOf(endString, startIdx + startString.length());
                        str = str.substring(startIdx + startString.length(), endIdx);
                        if(str.matches("[0-9]+")){
                            numOfWinner = Integer.parseInt(str);
                        }

                    }

                    ///// 2. 로또 당첨 금액 알아내기 직전
                    if(str.contains("text-right vmiddle")){
                        isBeforeWon = true;
                        continue;
                    }
                    
                    ///// 2-1. 당첨 금액 확인
                    if(isBeforeWon == true) {
                        isBeforeWon = false;
                        str = str.replaceAll(regNondigits, "").replaceAll(",", "");
                        currLottoPrice = Long.parseLong(str);
                        sumLottoPrice += (currLottoPrice * numOfWinner);

                    }

                    if (str.contains("<a class=\"font-weight-bold\" href=\"/lottowinnumberdetail/fo/lottowinnumberdetailview/")) {
                        if(str.replaceAll(regNondigits, "").equals(1)){
                            i = 0;
                        }
                        System.out.print("" + str.replaceAll(regNondigits, ""));
                    }
                    if (count == 1 && str.contains("<div class=\"d-inline-block circleNumber border-")) {
                        System.out.print("Lotto Number is " + str.replaceAll(regNondigits, ""));
                        count++;
                    } else if (str.contains("<div class=\"d-inline-block circleNumber border-")) {
                        String eachLottoNum = str.replaceAll(regNondigits, "");
                        if(lottoNumCountMap.containsKey(eachLottoNum)){
                            lottoNumCountMap.put(eachLottoNum,lottoNumCountMap.get(eachLottoNum) + 1);
                        }else {
                            lottoNumCountMap.put(eachLottoNum,1);
                        }

                        System.out.print(" " + str.replaceAll(regNondigits, "") + " ");
                        count++;
                    }
                    if (count >= 8) {
                        count = 1;
                        System.out.println();
                    }
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("sumLottoPrice : " + sumLottoPrice);
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(lottoNumCountMap.entrySet());
//        for(Map.Entry<String, Integer> entry : entryList){
//            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
//        }
        entryList.sort(((o1, o2) -> lottoNumCountMap.get(o2.getKey()) - lottoNumCountMap.get(o1.getKey())));

        int ii = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            if( ii < 10) {
                System.out.println("num : " + entry.getKey() + ", count : " + entry.getValue());
            }
            ii++;
        }


    }
}
