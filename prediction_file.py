import sys
import pickle
import pandas as pd

try:
    model = pickle.load(open("health_model.pkl", "rb"))
    le = pickle.load(open("health_encoder.pkl", "rb"))

    water = float(sys.argv[1])
    sleep = float(sys.argv[2])
    exercise = float(sys.argv[3])

    input_df = pd.DataFrame(
        [[water, sleep, exercise]],
        columns=["water_liters", "sleep_hours", "exercise_minutes"]
    )

    prediction = model.predict(input_df)[0]
    result = le.inverse_transform([prediction])[0]

    print(result, flush=True)

except Exception:
    print("Invalid input", flush=True)
