package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

//import main.java.sample.model.Recipe;
//import main.java.sample.model.Ingredient;
import sample.model.Ingredient;
import sample.model.JavaMySQLTest;
import sample.model.Recipe;

import static sample.model.Ingredient.FoodCategory.*;


public class IngredientMenuController implements Initializable {

    private static final int NUM_BUTTON_LINES = 5;
    private static final int BUTTONS_PER_LINE = 3;
    private static final int MAX_INGREDIENTS = 100;
    private static final int MAX_RECIPES = 100;

    @FXML GridPane grid;
    @FXML ListView list1 = new ListView();
//    String proteins[] = {"Chicken", "Beef", "Turkey"};
//    String vegetables[] = {"Broccoli", "Carrot", "Pea"};

    @FXML TextArea textArea1;
    String ingredients = "";
//    String spaghetti = "beef pasta spaghetti-sauce oil";
//    String chickenParm = "chicken bread-crumble oil pasta spaghetti-sauce";
//    ArrayList<String> possibleRecipesString = new ArrayList<>();
//    ArrayList<String> chosenIngredientsString = new ArrayList<>();

    ArrayList<Recipe> allRecipes;
    ArrayList<Recipe> possibleRecipes;
    ArrayList<Ingredient> allIngredients;
    ArrayList<Ingredient> proteinIngredients;
    ArrayList<Ingredient> carbIngredients;
    ArrayList<Ingredient> veggieIngredients;
    ArrayList<Ingredient> sauceIngredients;
    ArrayList<Ingredient> chosenIngredients;

//    main.java.sample.model.Recipe recipe1;
//    main.java.sample.model.Ingredient ingredient1;
//    main.java.sample.model.Ingredient ingredient2;
//    main.java.sample.model.Ingredient ingredient3;

    @FXML FlowPane proteinPane;
    @FXML FlowPane carbPane;
    @FXML FlowPane veggiePane;
    @FXML FlowPane saucePane;

    @FXML Button addIngredientButton;
    @FXML Button displayRecipesButton;

    /*****************************
     *
     * @return string array of recipe names
     ****************************/
    public ArrayList<Recipe> search(){
//
//        ArrayList<Recipe> tempList = new ArrayList<>();
//        Recipe tempRecipe;
//
//        for(int i = 0; i < possibleRecipesString.size(); i++) {
//            for(int j = 0; j < chosenIngredientsString.size(); j++) {
//                if (possibleRecipesString.get(i).contains(chosenIngredientsString.get(j))) {
//
//                }
//            }
//        }
        return null;
    }
    /*******************************
     * displays the Recipe to command line
     * @param event
     */
    public void displayRecipeButtonPressed(ActionEvent event) {
        for(Recipe e: allRecipes){
            System.out.println(e.toString());
        }
    }

    /*********************************
     Fills Grid full of buttons
     * @param event
     *********************************/
    public void fillGrid(ActionEvent event) {
        for (int r = 0; r < NUM_BUTTON_LINES; r++) {
            for (int c = 0; c < BUTTONS_PER_LINE; c++) {
                int number = NUM_BUTTON_LINES * r + c;
                Button button = new Button(String.valueOf(number));
                this.grid.add(button, c, r);
            }
        }
    }

    /*******************************
     * Fills the list view
     * @param ar array holding items
     *******************************/
    void fillListView(String[] ar) {

        for (int i = 0; i < MAX_INGREDIENTS; i++) {

            this.list1.getItems().add(ar[i]);

        }
    }
    /******************************
     *
     *******************************/
    public void addIngredientButtonPushed(ActionEvent event) {

        System.out.println("pushed!");

        int count = 0;

        //======== check protein pane =========
        ObservableList<Node> proteinList = proteinPane.getChildren();
        for (int i =0; i < proteinList.size(); i++) {
            CheckBox cb = (CheckBox)proteinList.get(i);
            if (cb.isSelected()){
                //====== THIS IS WHERE INGREDIENTS GET ADDED TO "Button Lists"=====
                count++;
            }
        }
        //======== check carb pane =========
        ObservableList<Node> carbList = carbPane.getChildren();
        for (int i =0; i < carbList.size(); i++) {
            CheckBox cb = (CheckBox)carbList.get(i);
            if (cb.isSelected()){
                //====== THIS IS WHERE INGREDIENTS GET ADDED TO "Button Lists"=====
                count++;
            }
        }
        //======== check veggie pane =========
        ObservableList<Node> veggieList = veggiePane.getChildren();
        for (int i =0; i < veggieList.size(); i++) {
            CheckBox cb = (CheckBox)veggieList.get(i);
            if (cb.isSelected()){
                //====== THIS IS WHERE INGREDIENTS GET ADDED TO "Button Lists"=====
                count++;
            }
        }
        //======== check Sauce pane =========
        ObservableList<Node> sauce = veggiePane.getChildren();
        for (int i =0; i < veggieList.size(); i++) {
            CheckBox cb = (CheckBox)veggieList.get(i);
            if (cb.isSelected()){
                //====== THIS IS WHERE INGREDIENTS GET ADDED TO "Button Lists"=====
                count++;
            }
        }
        System.out.println("count=" + count);
    }

    /*******************************
     *
     ******************************/
    public void ingredientPush(ActionEvent event){

//        ObservableList list = list1.getSelectionModel().getSelectedItems();
//
//        for (Object item: list) {
//            if(ingredients.contains((String) item)){
//                continue;
//            }
//            chosenIngredientsString.add((String)item);//keep track of chosen ingredients
//            this.ingredients += String.format("%s%n", (String)item);
//        }
//        textArea1.setText(this.ingredients);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //allRecipes = new ArrayList<>();
        //allIngredients = new ArrayList<>();
        proteinIngredients = new ArrayList<>();
        carbIngredients = new ArrayList<>();
        veggieIngredients = new ArrayList<>();
        sauceIngredients = new ArrayList<>();

        //==== adding data using mySQL ===========
        allIngredients = new ArrayList<>(JavaMySQLTest.getAllIngredients());
        allRecipes = new ArrayList<>(JavaMySQLTest.getAllRecipes());


        //====== Move ingredients from allIngredient to separate ArrayLists ============
        //Iterate through all ingredients, and one by one place each ingredient into its appropriate
        //categorical ArrayList
        for(int i=0; i < allIngredients.size(); i++){

            switch (allIngredients.get(i).getCategory()){

                case PROTEIN:
                    proteinIngredients.add(allIngredients.get(i));
                    break;
                case CARB:
                    carbIngredients.add(allIngredients.get(i));
                    break;
                case VEGGIE:
                    veggieIngredients.add(allIngredients.get(i));
                    break;
                case SAUCE:
                    sauceIngredients.add(allIngredients.get(i));
                    break;
            }
        }

        //========= adding ingredients to correct Tile Pane =============
        CheckBox checkBox = null;
        for (Ingredient item : proteinIngredients) {
            checkBox = new CheckBox(item.getName());
            System.out.println("Added?=" + proteinPane.getChildren().add(checkBox));
        }
        for (Ingredient item : carbIngredients) {
            checkBox = new CheckBox(item.getName());
            System.out.println("Added?=" + carbPane.getChildren().add(checkBox));
        }
        for (Ingredient item : veggieIngredients) {
            checkBox = new CheckBox(item.getName());
            System.out.println("Added?=" + veggiePane.getChildren().add(checkBox));
        }
        for (Ingredient item : sauceIngredients) {
            checkBox = new CheckBox(item.getName());
            System.out.println("Added?=" + saucePane.getChildren().add(checkBox));
        }

        //create check boxes and
        //add check boxes for dairy pane
//        CheckBox checkBox = null;
//        for (Ingredient dairyIngredient : dairyIngredients) {
//            checkBox = new CheckBox(dairyIngredient.getName());
//            System.out.println("Added?=" + dairyPane.getChildren().add(checkBox));
//        }

        /*************************************************************************/

        //get possibleRecipesString ready
//        possibleRecipesString.add(spaghetti);
//        possibleRecipesString.add(chickenParm);
//        //get list ready
//        list1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}
