# PersonIsPregnant
This is a prediction tool for the PersonIsPregnant dataset. This dataset is categorical and contains 4 features with 2 possible values for each feature and a single label being "Yes" or "No".

Frequency table:

| Row Labels | No  | Yes | Grand Total |
|------------|-----|-----|-------------|
| **Old**    | 54  | 50  | 104         |
| High       | 32  | 26  | 58          |
| Missed     | 13  | 11  | 24          |
| Mild       | 9   | 9   | 18          |
| Severe     | 4   | 2   | 6           |
| Regular    | 19  | 15  | 34          |
| Mild       | 12  | 6   | 18          |
| Severe     | 7   | 9   | 16          |
| Low        | 22  | 24  | 46          |
| Missed     | 10  | 13  | 23          |
| Mild       | 3   | 8   | 11          |
| Severe     | 7   | 5   | 12          |
| Regular    | 12  | 11  | 23          |
| Mild       | 5   | 9   | 14          |
| Severe     | 7   | 2   | 9           |
| **Young**  | 50  | 46  | 96          |
| High       | 21  | 23  | 44          |
| Missed     | 8   | 14  | 22          |
| Mild       | 3   | 7   | 10          |
| Severe     | 5   | 7   | 12          |
| Regular    | 13  | 9   | 22          |
| Mild       | 8   | 4   | 12          |
| Severe     | 5   | 5   | 10          |
| Low        | 29  | 23  | 52          |
| Missed     | 11  | 12  | 23          |
| Mild       | 7   | 4   | 11          |
| Severe     | 4   | 8   | 12          |
| Regular    | 18  | 11  | 29          |
| Mild       | 8   | 6   | 14          |
| Severe     | 10  | 5   | 15          |
| **Grand Total** | **104** | **96** | **200** |


### Female.java
Represents a female subject with features such as age group, stress level, menstrual pattern, morning sickness, and pregnancy status. It stores this information for use in model training and prediction.

### FileProcessor.java
Handles loading data from the pregnancy_dataset.csv file

Methods
- connectToFile() - prepares the file for reading
- readFile() - reads lines from the csv
- loadFemaleData() - converts the lines into a list of Female objects

### Trainer.java
This class is responsible for training and testing the Naive Bayes model. It splits the dataset into 150 lines for training and 50 lines for testing, ensuring a balanced distribution between the “Yes” and “No” classes. The model is then trained using the training data, and its accuracy is evaluated using the test data.

### Predictor.java
This class implements the Naive Bayes approach for training and making predictions. It uses feature frequencies to calculate the probability of a female being pregnant based on input features such as age group, stress level, menstrual pattern, and morning sickness.

Main features:
- Training: It counts feature occurrences for both “Yes” and “No” pregnancy labels and stores these counts.
- Prediction: It calculates the probabilities for “Yes” and “No” pregnancy outcomes based on the trained data and returns the predicted outcome and its probability.
- Model update: It allows for learning by adding new examples to the model, updating the counts accordingly.
 
### GUI.java
This class handles the graphical user interface for the application. It provides dropdowns for the user to input feature values like age group, stress level, menstrual pattern, and morning sickness level. It includes a Predict button to generate a pregnancy prediction and a Save button to add a new example to the model. The prediction result is displayed on the screen. The GUI communicates with the Main class to perform predictions and update the model.

### What I would add if i had more time
I would improve the system for continuous learninng. When users add new data, it would be added directly to the csv file. Once the data is added, the model could be retrained to improve its predictions and accuracy over time. 
