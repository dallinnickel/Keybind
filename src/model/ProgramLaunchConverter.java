package model;

import java.util.ArrayList;

public class ProgramLaunchConverter {

    /**
     * Takes the file path as a string and converts it to an ArrayList<Integer>. the first entry is always 10000, this is to identify it has a launch program hotkey.
     * @param s a string that represents the absolute path to the exe you wish to bind.
     * @return and ArrayList<Integer> of actions.
     */
    public static ArrayList<Integer> StringToInt(String s){
        ArrayList<Integer> actionList = new ArrayList<>();
        // Identifying keycode used to check during preform action if it's a launch program type.
        actionList.add(10000);

        try {
            byte[] bytes = s.getBytes("US-ASCII");
            //System.out.println(Arrays.toString(bytes));

            for(int i = 0; i< bytes.length; i = i +1){
                int p = bytes[i];
                //System.out.println(p);
                actionList.add(p);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return actionList;
    }


    /**
     * Converts ArrayList<Integer> back into a string of the path.
     * @param actionList an ArrayList who's value's represent character's in US-ASCII
     * @return a string of the file path.
     */
    public static String IntToString(ArrayList<Integer> actionList){
        String str = "";

        for(int i = 0; i< actionList.size(); i = i +1) {
            int temp = actionList.get(i);
            String c = Character.toString((char) temp);
            str += c;
        }
        return str;
    }


    /**
     * Makes a new Arraylist Without the leading Idenification of 10000. so the path is correct.
     * @param actionList an Arraylist with a leading 10000.
     * @return an Arraylist without a leading 10000.
     */
    public static ArrayList<Integer> RemoveIdentification(ArrayList<Integer> actionList){
        ArrayList<Integer> new_actionList = new ArrayList<Integer>();
        for(int i = 1; i< actionList.size(); i = i +1){
            new_actionList.add(actionList.get(i));
        }
        return new_actionList;
    }

}
