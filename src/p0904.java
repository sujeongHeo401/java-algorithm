    public boolean checkDistances(String s, int[] distance) {
        // distance = new int[] {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        // s = "aa";
        boolean answer = false;
        int test = 'a';
        char a = 97;
        // System.out.println("what ?? " + a); //// n + 97
        HashMap<String,Integer> sMap =new HashMap<String,Integer>();//Creating HashMap    
    
        for(int j = 0; j < s.length(); j++){
            String mapKey = String.valueOf(s.charAt(j));
            if(!sMap.containsKey(mapKey)){
                sMap.put(mapKey, j);
            } else {
                int sMapValue = sMap.get(mapKey);
                sMapValue = Math.abs(sMapValue - j) - 1; /// diff  
                if(sMapValue == -1) sMapValue = 0;
                sMap.put(mapKey, sMapValue);
            }
        }
        
        for(int i = 0; i < distance.length; i++){
            int checkValue = distance[i];
            String target = String.valueOf((char) (i + 97)); /// alphabet .................
            int compareValue = -1; // init
            if(!sMap.containsKey(target)){
                System.out.println("target ...????" + target);
                continue;
            }
            else {

                compareValue = sMap.get(target);
                if(checkValue != compareValue){
                    return false;
                }    
            }
            
        }
        // for(int j = 0; j < s.length(); j++){
        //     /// sth.....
        // }
        
        return true;
        
    }
