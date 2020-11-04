//package main.java.sample.model;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import static main.java.sample.model.Ingredient.RESET_I;
//
//public class IngredientTable {
//
//    private static int count;//Keeps track of how many ingredients are in the table.
//    private static int count_dairy = 0;//Keeps track of how many dairy ingredients are in the table.
//    private static int count_bakegrain = 0;//Keeps track of how many baking & grain ingredients are in the table.
//    private static int count_sauce = 0;//Keeps track of how many sauce ingredients are in the table.
//    private static int count_meat = 0;//Keeps track of how many meat ingredients are in the table.
//    final static int COLUMNS = 4;//Number of Ingredient data members admin want to display.
//
//    /********************************************************
//     * Prints the Ingredients Table text file.
//     *******************************************************/
//    public static void display(){
//
//        try{
//            BufferedReader br = new BufferedReader(new FileReader("IngredientTable.txt"));
//            String s = "";
//                while ( (s = br.readLine()) != null) {
//
//                    String data[];//Ingredient data
//                    data = new String[count];//Set size of data to be count (number of ingredients in the table).
//                    data = s.split(",");//Use comma as delimiter.
//
//                    for(int i = 0; i < COLUMNS; i++){
//
//                        /***********************************
//                         * WHERE THE INGREDIENT IS DISPLAYED
//                         ***********************************/
//                        System.out.print(data[i]+", ");
//                    }
//                    System.out.println();//newline
//                }
//            System.out.println("COUNT=" + count);
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//    /********************************************************
//     * Prints the Ingredients Table text file depending on a code
//     *******************************************************/
//    public static void display(int code){
//
//        String fileName = "";//initialize to "" to make compiler happy
//        int c = 0;//initialize to zero to make compiler happy
//        switch(code){
//            case 1:
//                fileName = "BakingGrainTable.txt";
//                c = count_bakegrain;
//                break;
//            case 2:
//                fileName = "DairyTable.txt";
//                c = count_dairy;
//                break;
//            case 3:
//                fileName = "MeatTable.txt";
//                c = count_meat;
//                break;
//            case 4:
//                fileName = "SauceTable.txt";
//                c = count_sauce;
//                break;
//        }
//
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(fileName));
//            String s = "";
//            while ( (s = br.readLine()) != null) {
//
//                String data[];//Ingredient data
//                /*********************************
//                 * ?????????????????????????????
//                 * These two lines below are funny.
//                 * Each one can exist w/o the other.
//                 * ???????????????????????????????
//                 *********************************/
//                data = new String[c];//Set size of data to be c (number of ingredients in the table).
//                data = s.split(",");//Use comma as delimiter.
//
//                for(int i = 0; i < COLUMNS; i++){
//
//                    /***********************************
//                     * WHERE THE INGREDIENT IS DISPLAYED
//                     ***********************************/
//                    System.out.print(data[i]+", ");
//                }
//                System.out.println();//newline
//            }
//            //System.out.println("COUNT=" + count);
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//    /********************************************************
//     * Displays a specific list of ingredients specific to a
//     * recipe.
//     * @param icode code that tells us which file to go into.
//     * @param rcode recipe id used to find correct ingredients.
//     *******************************************************/
//    public static void display(int icode, int rcode){
//
//        String fileName = "";//initialize to "" to make compiler happy
//        int c = 0;//initialize to zero to make compiler happy
//        switch(icode){
//            case 1:
//                fileName = "BakingGrainTable.txt";
//                c = count_bakegrain;
//                break;
//            case 2:
//                fileName = "DairyTable.txt";
//                c = count_dairy;
//                break;
//            case 3:
//                fileName = "MeatTable.txt";
//                c = count_meat;
//                break;
//            case 4:
//                fileName = "SauceTable.txt";
//                c = count_sauce;
//                break;
//        }
//
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(fileName));
//            String s = "";
//            while ( (s = br.readLine()) != null) {
//
//                String data[];//Ingredient data
//                data = new String[c];//Set size of data to be c (number of ingredients in the table).
//                data = s.split(",");//Use comma as delimiter.
//
//                for(int i = 0; i < COLUMNS; i++){
//
//                    /***********************************
//                     * WHERE THE INGREDIENT IS DISPLAYED
//                     ***********************************/
//                    System.out.print(data[i]+", ");
//                }
//                System.out.println();//newline
//            }
//            //System.out.println("COUNT=" + count);
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//    /*********************************************************************
//     * Writes to Ingredient .txt and .ser files
//     *********************************************************************/
//    public static void write(){
//        //System.out.println("2 | currentID=" + Ingredient.getCur_idI());
//
////        Ingredient ingredient = new Ingredient();
////        //System.out.println("3 | currentID=" + Ingredient.getCur_idI());
////
////        Scanner sc = new Scanner(System.in);
////
////        /*************************************
////         * User creates new Ingredient
////         *************************************/
////        System.out.println("Enter recipe ID:");
////        String idR = sc.nextLine();//ID Recipe
////        ingredient.setIdR(idR);
////
////        System.out.println("Enter name:");
////        String name = sc.nextLine();//name
////        ingredient.setName(name);
////
////        System.out.println("Enter amount:");
////        String amount = sc.nextLine();////amount
////        ingredient.setAmount(amount);
////
////        serializeIngredient(ingredient);//Adds new ingredient to .ser file
////
////        try{
////
////            File f = new File("IngredientTable.txt");
////            PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
////            pw.append(ingredient.getIdI() + "," + idR + "," + name + "," + amount + "\n");
////            //System.out.println("Ing ID=" + Ingredient.getCur_idI());
////            count++;
////            pw.close();
////
////        }
////        catch (Exception e){
////            System.out.println(e.getMessage());
////        }
//    }
//
//    /*********************************************************************
//     * Writes to Ingredient .txt and .ser files
//     *********************************************************************/
//    public static void write(int code){
//        //System.out.println("2 | currentID=" + Ingredient.getCur_idI());
//
//        Ingredient ingredient = new Ingredient();
//        //System.out.println("3 | currentID=" + Ingredient.getCur_idI());
//
//        Scanner sc = new Scanner(System.in);
//
//        /*************************************
//         * User creates new Ingredient
//         *************************************/
//        System.out.println("Enter recipe ID:");
//        String idR = sc.nextLine();//ID Recipe
//        ingredient.setIdR(idR);
//
//        System.out.println("Enter name:");
//        String name = sc.nextLine();//name
//        ingredient.setName(name);
//
//        System.out.println("Enter amount:");
//        String amount = sc.nextLine();//amount
//        ingredient.setAmount(amount);
//
//        serializeIngredient(ingredient, code);//Adds new ingredient to .ser file
//
//        String fileName = "";
//        switch(code){
//            case 1:
//                fileName = "BakingGrainTable.txt";
//                count_bakegrain++;
//                break;
//            case 2:
//                fileName = "DairyTable.txt";
//                count_sauce++;
//                break;
//            case 3:
//                fileName = "MeatTable.txt";
//                count_meat++;
//                break;
//            case 4:
//                fileName = "SauceTable.txt";
//                count_dairy++;
//                break;
//        }
//        try{
//            //First write to specific ingredient type table
//            File f = new File(fileName);
//            PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
//            pw.append(ingredient.getIdI() + "," + idR + "," + name + "," + amount + "\n");
//            pw.close();
//            //Then write to general ingredient table
//            f = new File("IngredientTable.txt");
//            pw = new PrintWriter(new FileOutputStream(f,true));
//            pw.append(ingredient.getIdI() + "," + idR + "," + name + "," + amount + "\n");
//            pw.close();
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//    /*******************************************************************
//     *
//     * @param code Lets function know which table to write to
//     * @param recipeID The id the ingredients will be assigned to.
//     * @return Returns a newly written Ingredient
//     ******************************************************************/
//    public static Ingredient write(int code, String recipeID){
//
//        Ingredient ingredient = new Ingredient();
//
//        Scanner sc = new Scanner(System.in);
//
//        /*************************************
//         * User creates new Ingredient
//         *************************************/
//        //Set recipe ID
//        ingredient.setIdR(recipeID);
//
//        System.out.println("Enter name:");
//        String name = sc.nextLine();//name
//        ingredient.setName(name);
//
//        System.out.println("Enter amount:");
//        String amount = sc.nextLine();//amount
//        ingredient.setAmount(amount);
//
//        serializeIngredient(ingredient, code);//Adds new ingredient to .ser file
//
//        String fileName = "";
//        switch(code){
//            case 1:
//                fileName = "BakingGrainTable.txt";
//                count_bakegrain++;
//                count++;
//                break;
//            case 2:
//                fileName = "DairyTable.txt";
//                count_sauce++;
//                count++;
//                break;
//            case 3:
//                fileName = "MeatTable.txt";
//                count_meat++;
//                count++;
//                break;
//            case 4:
//                fileName = "SauceTable.txt";
//                count_dairy++;
//                count++;
//                break;
//        }
//        try{
//            //First write to specific ingredient type table
//            File f = new File(fileName);
//            PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
//            pw.append(ingredient.getIdI() + "," + recipeID + "," + name + "," + amount + "\n");
//            pw.close();
//            //Then write to general ingredient table
//            f = new File("IngredientTable.txt");
//            pw = new PrintWriter(new FileOutputStream(f,true));
//            pw.append(ingredient.getIdI() + "," + recipeID + "," + name + "," + amount + "\n");
//            pw.close();
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return ingredient;
//    }
//    /**************************************************************
//     * Serializes an ingredient object and adds it the .ser file
//     * @param ingredient Object that will become serialized and added
//     *                   to "IngredientTable.ser"
//     **************************************************************/
//    private static void serializeIngredient(Ingredient ingredient, int code){
//
//        String fileName = "";
//        switch(code){
//            case 1:
//                fileName = "BakingGrainTable.ser";
//                count_bakegrain++;
//                break;
//            case 2:
//                fileName = "SauceTable.ser";
//                count_sauce++;
//                break;
//            case 3:
//                fileName = "MeatTable.ser";
//                count_meat++;
//                break;
//            case 4:
//                fileName = "DairyTable.ser";
//                count_dairy++;
//                break;
//        }
//        try{
//            //First write to specific ingredient type file
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
//            oos.writeObject(ingredient);
//            //Then write to general ingredient file
//            oos = new ObjectOutputStream(new FileOutputStream("IngredientTable.ser"));
//            oos.writeObject(ingredient);
//            System.out.println("Done Serializing!");
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    /**********************************************
//     * Clears the .txt File and .ser File
//     **********************************************/
//    public static void clearTables() {
//        try {
//            new FileWriter("IngredientTable.txt", false).close();//code that clears table
//            new FileWriter("IngredientTable.ser", false).close();//code that clears table
//            count = 0;//sets number of ingredients back to zero because table is clear
//            Ingredient.resetCur_idI();
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    /**********************************************
//     * Clears the .txt File and .ser File depending
//     * on the code parameter. BSMD
//     **********************************************/
//    public static void clearTable(int code) {
//        try {
//
//            switch (code){
//                case 1:
//                    new FileWriter("BakingGrainTable.txt", false).close();//code that clears table
//                    new FileWriter("BakingGrainTable.ser", false).close();//code that clears table
//                    //Ingredient.setCur_idI( getCur_idI() - count_bakegrain );//when a table is cleared we need to createIngredients current ID
//                    count_bakegrain = 0;//sets number of baking & grain ingredients back to zero because table is clear
//                    break;
//                case 2:
//                    new FileWriter("SauceTable.txt", false).close();//code that clears table
//                    new FileWriter("SauceTable.ser", false).close();//code that clears table
//                    //Ingredient.setCur_idI( getCur_idI() - count_sauce );//when a table is cleared we need to createIngredients current ID
//                    count_sauce = 0;//sets number of baking & grain ingredients back to zero because table is clear
//                    break;
//                case 3:
//                    new FileWriter("MeatTable.txt", false).close();//code that clears table
//                    new FileWriter("MeatTable.ser", false).close();//code that clears table
//                    //Ingredient.setCur_idI( getCur_idI() - count_meat );//when a table is cleared we need to createIngredients current ID
//                    count_meat = 0;//sets number of baking & grain ingredients back to zero because table is clear
//                    break;
//                case 4:
//                    new FileWriter("DairyTable.txt", false).close();//code that clears table
//                    new FileWriter("DairyTable.ser", false).close();//code that clears table
//                    //Ingredient.setCur_idI( getCur_idI() - count_dairy );//when a table is cleared we need to createIngredients current ID
//                    count_dairy = 0;//sets number of baking & grain ingredients back to zero because table is clear
//                    break;
//            }
////            new FileWriter("IngredientTable.txt", false).close();//code that clears table
////            new FileWriter("IngredientTable.ser", false).close();//code that clears table
////            count = 0;//sets number of ingredients back to zero because table is clear
////            Ingredient.resetCur_idI();
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    /**********************************************
//     * Clears count_I.txt
//     **********************************************/
//    public static void clearCountFile() {
//        try {
//            new FileWriter("count_I.txt", false).close();//code that clears the file.
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    /**********************************************
//     * Clears all count .txt files
//     **********************************************/
//    public static void clearCountFiles() {
//        try {
//            new FileWriter("count_I.txt", false).close();//code that clears the file.
//            new FileWriter("count_Dairy.txt", false).close();//code that clears the file.
//            new FileWriter("count_Meat.txt", false).close();//code that clears the file.
//            new FileWriter("count_BakingGrain.txt", false).close();//code that clears the file.
//            new FileWriter("count_Sauce.txt", false).close();//code that clears the file.
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    /**********************************************
//     * Clears a certain count file
//     **********************************************/
//    public static void clearCountFile(int code) {
//        String fileName = "";
//        switch(code){
//            case 1:
//                fileName = "count_BakingGrain.txt";
//                break;
//            case 2:
//                fileName = "count_Dairy.txt";
//                break;
//            case 3:
//                fileName = "count_Meat.txt";
//                break;
//            case 4:
//                fileName = "count_Sauce.txt";
//                break;
//        }
//            try {
//                new FileWriter(fileName, false).close();//code that clears the file.
//            }
//            catch (Exception e){
//                System.out.println(e.getMessage());
//                e.printStackTrace();
//            }
//    }
//
//    /********************************************************************
//     * Test Ingredient Table
//     ********************************************************************/
//    public static void main(String[] args){
//
//        /***************************
//         * Get the correct counts for
//         * each type of ingredient
//         **************************/
//        count_bakegrain = getCountFromFile("count_BakingGrain.txt");
//        count_dairy = getCountFromFile("count_Dairy.txt");
//        count_meat = getCountFromFile("count_Meat.txt");
//        count_sauce = getCountFromFile("count_Sauce.txt");
//
//        Ingredient.setCur_idI(RESET_I + count);//current ID = 1000000 + count
//
//        boolean running = true;
//        while(running) {
//            //DISPLAY MENU
//            System.out.println("1. Add Item");
//            System.out.println("2. Display Item");
//            System.out.println("3. Clear Tables");
//            System.out.println("4. Exit");
//            //CREATE SCANNER AND GET INPUT
//            Scanner sc = new Scanner(System.in);
//            String input = sc.nextLine();
//            //CHECK INPUT
//            while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
//                System.out.println("Must answer 1 , 2, 3 or 4:");
//                input = sc.nextLine();
//            }
//
//            if (input.equals("1")) {
//                //DISPLAY MENU
//                System.out.println("1. Add Baking or Grain Ingredient");
//                System.out.println("2. Add Sauce Ingredient");
//                System.out.println("3. Add Meat Ingredient");
//                System.out.println("4. Add Dairy Ingredient");
//
//                input = sc.nextLine();
//                //CHECK INPUT
//                while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
//                    System.out.println("Must answer 1 , 2, 3 or 4:");
//                    input = sc.nextLine();
//                }
//                IngredientTable.write(Integer.parseInt(input));//CHANGED MAIN HERE
//
//            } else if (input.equals("2")) {
//
//                //DISPLAY MENU
//                System.out.println("1. Display Baking & Grain Ingredients");
//                System.out.println("2. Display Dairy Ingredients");
//                System.out.println("3. Display Meat Ingredients");
//                System.out.println("4. Display Sauce Ingredients");
//
//                input = sc.nextLine();
//                //CHECK INPUT
//                while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
//                    System.out.println("Must answer 1 , 2, 3 or 4:");
//                    input = sc.nextLine();
//                }
//                IngredientTable.display(Integer.parseInt(input));//CHANGED
//
//            } else if (input.equals("3")) {
//
//                //CLEAR MENU
//                System.out.println("1. Clear Baking & Grain Ingredients");
//                System.out.println("2. Clear Sauce Ingredients");
//                System.out.println("3. Clear Meat Ingredients");
//                System.out.println("4. Clear Dairy Ingredients");
//
//                input = sc.nextLine();
//                //CHECK INPUT
//                while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
//                    System.out.println("Must answer 1 , 2, 3 or 4:");
//                    input = sc.nextLine();
//                }
//                IngredientTable.clearTable(Integer.parseInt(input));//CHANGED
//
//            } else if(input.equals("4")){
//                IngredientTable.exit2();
//                running = false;
//                System.out.println("Thank you, goodbye.");
//            }
//        }
//    }
//
//    /********************************************************************
//     * Table Driver
//     * Allows user to createIngredients the Ingredient Tables
//     * WARNING, clearTable() is VERY DANGEROUS !!! CAN CORRUPT RECIPES
//     ********************************************************************/
//    public static ArrayList<Ingredient> createIngredients(int recipeID){
//
//        ArrayList<Ingredient> ingredientArrayList = new ArrayList<>();
//
//        /***************************
//         * Get the correct counts for
//         * each type of ingredient
//         **************************/
//        count_bakegrain = getCountFromFile("count_BakingGrain.txt");
//        count_dairy = getCountFromFile("count_Dairy.txt");
//        count_meat = getCountFromFile("count_Meat.txt");
//        count_sauce = getCountFromFile("count_Sauce.txt");
//
//        Ingredient.setCur_idI(RESET_I + count);//current ID = 1000000 + count
//
//        boolean running = true;
//        while(running) {
//            //DISPLAY MENU
//            System.out.println("1. Add Ingredient");
//            System.out.println("2. Display Ingredients ***UNDER CONSTRUCTION***");
//            System.out.println("3. Exit");
//            //CREATE SCANNER AND GET INPUT
//            Scanner sc = new Scanner(System.in);
//            String input = sc.nextLine();
//            //CHECK INPUT
//            while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
//                System.out.println("Must answer 1 , 2 or 3:");
//                input = sc.nextLine();
//            }
//
//            if (input.equals("1")) {
//                //DISPLAY MENU
//                System.out.println("1. Add Baking or Grain Ingredient");
//                System.out.println("2. Add Dairy Ingredient");
//                System.out.println("3. Add Meat Ingredient");
//                System.out.println("4. Add Sauce Ingredient");
//
//                input = sc.nextLine();
//                //CHECK INPUT
//                while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
//                    System.out.println("Must answer 1 , 2, 3 or 4:");
//                    input = sc.nextLine();
//                }
//                /************************************************
//                 * Write Ingredient to DB and add it to the List
//                 ***********************************************/
//                ingredientArrayList.add(IngredientTable.write(Integer.parseInt(input), Integer.toString(recipeID)));
//
//            } else if (input.equals("2")) {
//
//                //DISPLAY MENU
//                System.out.println("1. Display Baking & Grain Ingredients");
//                System.out.println("2. Display Dairy Ingredients");
//                System.out.println("3. Display Meat Ingredients");
//                System.out.println("4. Display Sauce Ingredients");
//
//                input = sc.nextLine();
//                //CHECK INPUT
//                while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
//                    System.out.println("Must answer 1 , 2, 3 or 4:");
//                    input = sc.nextLine();
//                }
//                IngredientTable.display(Integer.parseInt(input));//CHANGED
//
//            } else if(input.equals("3")){
//                IngredientTable.exit2();
//                running = false;
//            }
//        }
//        return ingredientArrayList;
//    }
//    /*****************************************************************************
//     * Exits the programs and saves the count (number of ingredients in the table)
//     * to a text file: count_I.txt
//     *****************************************************************************/
//    public static void exit() {
//
//        try{
//
//            File f = new File("count_I.txt");
//            PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
//
//            IngredientTable.clearCountFile();//clear old count
//            //Ingredient.resetCur_idI(); i dont think this line is needed but idk...
//            pw.write(Integer.toString(count));//write new count
//            pw.close();
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//
//        System.out.println("THANK YOU! GOOD BYE!");
//        System.exit(0);
//    }
//    /*****************************************************************************
//     * Exits the programs and saves the count (number of ingredients in the table)
//     * to a text file: count_I.txt
//     *****************************************************************************/
//    public static void exit2() {
//
//        System.out.println("countBG=" + count_bakegrain);
//        System.out.println("countD=" + count_dairy);
//        System.out.println("countM=" + count_meat);
//        System.out.println("countS=" + count_sauce);
//        try{
//
//            File fold = new File("count_BakingGrain.txt");
//            fold.delete();
//            File fnew = new File("count_BakingGrain.txt");
//            FileWriter fw = new FileWriter(fnew, false);
//            fw.write(Integer.toString(count_bakegrain));
//            fw.close();
//
//            fold = new File("count_Dairy.txt");
//            fold.delete();
//            fnew = new File("count_Dairy.txt");
//            fw = new FileWriter(fnew, false);
//            fw.write(Integer.toString(count_dairy));
//            fw.close();
//
//            fold = new File("count_Meat.txt");
//            fold.delete();
//            fnew = new File("count_Meat.txt");
//            fw = new FileWriter(fnew, false);
//            fw.write(Integer.toString(count_meat));
//            fw.close();
//
//            fold = new File("count_Sauce.txt");
//            fold.delete();
//            fnew = new File("count_Sauce.txt");
//            fw = new FileWriter(fnew, false);
//            fw.write(Integer.toString(count_sauce));
//            fw.close();
//
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//        System.out.println("RECIPE CREATED!");
//    }
//
//    /*************************************************************************
//     * Reads the count (number of ingredients in the table) from count_I.txt and
//     * returns the value. Assumes count_I.txt is properly formatted.
//     * Returns -1 if exception is caught.
//     ************************************************************************/
//    public static int getCountFromFile() {
//        try {
//            File file = new File("count_I.txt");
//            Scanner sc = new Scanner(file);
//
//            int c = Integer.parseInt(sc.nextLine());
//
//            return c;
//        }
//        catch(Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//            return -1;
//        }
//    }
//    /*************************************************************************
//     * Reads the count (number of ingredients in the table) from a count .txt
//     * file and returns the value. Assumes count_I.txt is properly formatted.
//     * Returns -1 if exception is caught.
//     * @return fileName Filename to be read from
//     ************************************************************************/
//    public static int getCountFromFile(String fileName) {
//        try {
//            File file = new File(fileName);
//            Scanner sc = new Scanner(file);
//
//            int c = Integer.parseInt(sc.nextLine());
//
//            return c;
//        }
//        catch(Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//            return -1;
//        }
//    }
//}
