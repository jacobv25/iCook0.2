package sample.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JavaMySQLTest {


//    public static  List<Ingredient> getRecipeIngredientList(int idRecipe){
//
//
//    }

    /**************************************************************
     * Gets Recipe ID and name from the database
     * @return a List of all the recipes
     **************************************************************/
    public static List<Recipe> getAllRecipes() {

        List<Recipe> allRecipes = new ArrayList<>();

        try {
            String url = "jdbc:mysql://localhost:3306/icookdb";
            String username = "root";
            String password = "password";

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");

            //String sql = "SELECT recipe.idR, recipe.nameR, ingredient.idI, ingredient.nameI, ingredient.amount, ingredient.category FROM recipe INNER JOIN ingredient ON recipe.idR = ingredient.idR";
            String sql = "SELECT * FROM recipe";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            int count = 0;
            int idR;//recipe id
            //int idI;//ingredient id


            String nameR;
            //String nameI;
            //String amount;


            //Ingredient.FoodCategory foodCategory;
            //Ingredient ingredient;
            Recipe recipe;

            while (resultSet.next()){
                idR = resultSet.getInt("idR");
                nameR = resultSet.getString("nameR");
//                idI = resultSet.getInt("idI");
//                nameI = resultSet.getString("nameI");
//                amount = resultSet.getString("amount");
//                //Slightly convoluted way to retrieve enums from mySQL
//                foodCategory = Ingredient.FoodCategory.valueOf(resultSet.getString("category"));

                count++;

                recipe = new Recipe(idR, nameR);

                //ingredient = new Ingredient(Integer.toString(idR), nameI, amount, foodCategory);
                //System.out.println("Ingredient " + count + ": " + idR + ", " + nameI + ", " + amount);
                //System.out.println("Ingredient was added to recipe: " + nameR +"!");
                //recipe.addIngredient(ingredient);

                allRecipes.add(recipe);
            }
            connection.close();

            System.out.println("number of recipes=" + allRecipes.size());
            return allRecipes;
        } catch (SQLException e) {
            System.out.println("Oops, error!");
            e.printStackTrace();
        }

        return allRecipes;
    }

    public static ArrayList<Ingredient> getAllIngredients(){

        ArrayList<Ingredient> allIngredients = new ArrayList<>();

        try {
            String url = "jdbc:mysql://localhost:3306/icookdb";
            String username = "root";
            String password = "password";

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");

            String sql = "SELECT * FROM ingredient";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            int count = 0;
            int idR;
            String name;
            String amount;
            Ingredient.FoodCategory foodCategory;
            Ingredient ingredient;
            while (resultSet.next()){
                idR = resultSet.getInt("idR");
                name = resultSet.getString("nameI");
                amount = resultSet.getString("amount");
                //Slightly convoluted way to retrieve enums from mySQL
                foodCategory = Ingredient.FoodCategory.valueOf(resultSet.getString("category"));

                count++;
                ingredient = new Ingredient(Integer.toString(idR), name, amount, foodCategory);
                System.out.println("Ingredient " + count + ": " + idR + ", " + name + ", " + amount);
                System.out.println("was added to allIngredients!");
                allIngredients.add(ingredient);
            }
            connection.close();

            return allIngredients;
        } catch (SQLException e) {
            System.out.println("Oops, error!");
            e.printStackTrace();
        }
        return allIngredients;
    }

    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/icookdb";
        String username = "root";
        String password = "password";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");

//            String sql = "INSERT INTO ingredient (idR, name, amount) VALUES (?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, 1);
//            statement.setString(2, "Spag Sauce");
//            statement.setString(3, "1 jar");
//            int rows = statement.executeUpdate();
//            if (rows > 0){
//                System.out.println("A row has been inserted.");
//            }
//            statement.close();
            String sql = "SELECT * FROM ingredient";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int count = 0;
            int idR;
            String name;
            String amount;
            while (resultSet.next()){
                idR = resultSet.getInt("idR");
                name = resultSet.getString("name");
                amount = resultSet.getString("amount");
                count++;
                System.out.println("Ingredient " + count + ": " + idR + ", " + name + ", " + amount);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Oops, error!");
            e.printStackTrace();
        }
    }
}
