import os
import json

# Folders to scan
CATEGORIES = [
    "Strings", "Arrays", "Trees", "Graphs", "DP", "Hashing",
    "TwoPointers", "SlidingWindow", "Stack", "Queue",
    "BinarySearch", "Greedy", "Backtracking"
]

files = []

for category in CATEGORIES:
    folder_path = os.path.join(".", category)
    if os.path.exists(folder_path):
        # get all .java files in the folder
        for f in os.listdir(folder_path):
            if f.endswith(".java"):
                files.append(os.path.join(folder_path, f))

if not files:
    print("No solved problems found.")
    exit(0)

# latest = most recently modified
latest = max(files, key=os.path.getmtime)

print(f"Latest solved problem: {latest}")

with open('progress.json', 'w') as f:
    json.dump({"latest": latest, "count": len(files)}, f, indent=2)

print("Progress updated successfully!")
