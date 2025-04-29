# PersonIsPregnant
This is a prediction tool for the PersonIsPregnant dataset. This dataset is categorical and contains 4 features with 2 possible values for each feature and a single label being "Yes" or "No".


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

