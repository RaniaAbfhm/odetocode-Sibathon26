import sys
import pickle
import pandas as pd


with open("disease_model.pkl", "rb") as f:
    model = pickle.load(f)

with open("label_encoder.pkl", "rb") as f:
    le = pickle.load(f)


data = pd.read_csv("disease_prediction_dataset.csv")
selected_features = ["fever", "cough", "fatigue", "headache", "nausea"]


try:
    input_values = [int(x) for x in sys.argv[1:]]
except ValueError:
    print("Invalid input: please enter numbers only", flush=True)
    sys.exit(1)

if len(input_values) != len(selected_features):
    print(f"Expected {len(selected_features)} inputs, got {len(input_values)}", flush=True)
    sys.exit(1)


input_df = pd.DataFrame([input_values], columns=selected_features)


prediction = model.predict(input_df)[0]
predicted_disease = le.inverse_transform([prediction])[0]

print(predicted_disease, flush=True)
