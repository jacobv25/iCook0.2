//package main.java.sample.model;
//
//import java.io.*;
//import java.util.Scanner;
//
//import static main.java.sample.model.Recipe.RESET_R;
//
//public class RecipeTable {
//
//    private static int count;//Keeps track of how many recipes are in the table.
//    final static int ROWS = 2;//Number of recipe data members admin want to display.
//
//    /********************************************************
//     * Prints the Recipe Table text file.
//     *******************************************************/
//    public static void display(){
//
//
//        try{
//            BufferedReader br = new BufferedReader(new FileReader("RecipeTable.txt"));
//            Recipe recipe = deserializeRecipe("RecipeTable.ser");
//            String s = "";
//            while ( (s = br.readLine()) != null) {
//
//                String data[];//Recipe data
//                data = new String[count];//Set size of data to be count (number of recipe in the table).
//                data = s.split(",");//Use comma as delimiter.
//
//                for(int i=0; i < ROWS; i++){
//
//                    /***********************************
//                     * WHERE THE RECIPE IS DISPLAYED
//                     ***********************************/
//                    System.out.print(data[i]+", ");
//                    /***********************************
//                     * WHERE THE RECIPE'S INGREDIENTS
//                     * ARE DISPLAYED
//                     ***********************************/
//
//                }
//                System.out.println();//newline
//            }
//            System.out.println("COUNT=" + count);
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//    /*********************************************************************
//     * Writes to Recipe .txt and .ser files
//     *********************************************************************/
//    public static Recipe write(){
//
//        Scanner sc = new Scanner(System.in);
//
//        /*************************************
//         * User creates new Recipe
//         *************************************/
//        System.out.println("Enter recipe name:");
//        String name = sc.nextLine();//Recipe name
//        Recipe recipe = new Recipe(name);
//
//        serializeRecipe(recipe);//Adds new recipe to .ser file
//
//        try{
//
//            File f = new File("RecipeTable.txt");
//            PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
//            pw.append(recipe.getIdR() + "," + name + "\n");
//            count++;
//            pw.close();
//
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        /*******************************
//         *Create Ingredient List and fill
//         * the object's array list
//         ******************************/
//        recipe.setIngredients(IngredientTable.createIngredients(recipe.getIdR()));
//
//        return recipe;
//    }
//
//    /**************************************************************
//     * Serializes an recipe object and adds it the .ser file
//     * @param recipe Object that will become serialized and added
//     *                   to "RecipeTable.ser"
//     **************************************************************/
//    private static void serializeRecipe(Recipe recipe){
//
//        try{
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("RecipeTable.ser"));
//            oos.writeObject(recipe);
//            System.out.println("Done Serializing!");
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    /**************************************************************
//     * Reads an object Recipe from file
//     * @param fileName Where we are retrieving our object
//     * @return The recipe read from fileName
//     ***************************************************************/
//    private static Recipe deserializeRecipe(String fileName){
//        Recipe recipe = null;
//        try (ObjectInputStream ois
//                     = new ObjectInputStream(new FileInputStream(fileName))) {
//
//            recipe = (Recipe) ois.readObject();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return recipe;
//    }
//
//    /**********************************************
//     * Clears the .txt File and .ser File
//     **********************************************/
//    public static void clearTables() {
//        try {
//            new FileWriter("RecipeTable.txt", false).close();//code that clears table
//            new FileWriter("RecipeTable.ser", false).close();//code that clears table
//            count = 0;//sets number of recipes back to zero because table is clear
//            Recipe.resetCur_idI();
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
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
//
//    public static void main(String[] args){
//
//        System.out.println("1 | currentID=" + Recipe.getCur_idR());
//        count = getCountFromFile();
//        Recipe.setCur_idR(RESET_R + count);//current ID = 1000000 + count
//
//        while(true) {
//            //DISPLAY MENU
//            System.out.println("1. Add Recipe");
//            System.out.println("2. Display All Recipes");
//            System.out.println("3. Clear Recipes");
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
//                RecipeTable.write();
//            } else if (input.equals("2")) {
//                RecipeTable.display();
//            } else if (input.equals("3")) {
//                RecipeTable.clearTables();
//            } else if(input.equals("4")){
//                RecipeTable.exit();
//            }
//        }
//    }
//
//    /*****************************************************************************
//     * Exits the programs and saves the count (number of recipes in the table)
//     * to a text file: count_I.txt
//     *****************************************************************************/
//    public static void exit() {
//
//        try{
//
//            File f = new File("count_R.txt");
//            PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
//            RecipeTable.clearCountFile();//clear old count
//            Recipe.resetCur_idI();
//            pw.write(Integer.toString(count));
//            pw.close();
//
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//
//        System.out.println("THANK YOU! GOOD BYE!");
//        System.exit(0);
//    }
//
//    /*************************************************************************
//     * Reads the count (number of recipes in the table) from count_I.txt and
//     * returns the value. Assumes count_I.txt is properly formatted.
//     * Returns -1 if exception is caught.
//     ************************************************************************/
//    public static int getCountFromFile() {
//        try {
//            File file = new File("count_R.txt");
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
//
//}
