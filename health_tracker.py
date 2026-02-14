import pandas as pd
from sklearn.ensemble import RandomForestClassifier
from sklearn.preprocessing import LabelEncoder
import pickle

# Load dataset
data = pd.read_csv("health_dataset.csv")

X = data[["water_liters", "sleep_hours", "exercise_minutes"]]
y = data["health_status"]

# Encode labels
le = LabelEncoder()
y_encoded = le.fit_transform(y)

# Train model
model = RandomForestClassifier(n_estimators=100, random_state=42)
model.fit(X, y_encoded)

# Save model & encoder
pickle.dump(model, open("health_model.pkl", "wb"))
pickle.dump(le, open("health_encoder.pkl", "wb"))

print("Health model trained and saved")
