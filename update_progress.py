import os, json

dirs = ["Arrays","Strings","Hashing","TwoPointers","SlidingWindow","Stack","Queue","BinarySearch","Greedy","Backtracking"]
progress = {}

for d in dirs:
    folder = os.path.join(".", d)
    if os.path.exists(folder):
        files = [f for f in os.listdir(folder) if f.endswith(".java")]
        progress[d] = len(files)

with open("progress.json","w") as f:
    json.dump(progress, f, indent=4)

print("Progress updated:", progress)
