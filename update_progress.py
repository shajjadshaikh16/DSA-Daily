import os, json, re

dirs = ["Strings","Arrays","Hashing","TwoPointers","SlidingWindow","Stack","Queue",
        "BinarySearch","Greedy","Backtracking","Trees","Graphs","DP"]

progress = {}
total = 0
latest = None

for d in dirs:
    folder = os.path.join(".", d)
    if os.path.exists(folder):
        files = [f for f in os.listdir(folder) if f.endswith(".java")]
        progress[d] = len(files)
        total += len(files)
        if files:
            latest = max(files, key=os.path.getctime)

# Update README placeholders
with open("README.md","r") as f:
    readme = f.read()

for k,v in progress.items():
    placeholder = f"${{{k.upper()}_COUNT}}"
    readme = readme.replace(placeholder, str(v))

readme = readme.replace("${LATEST_PROBLEM}", latest or "N/A")

with open("README.md","w") as f:
    f.write(readme)

with open("progress.json","w") as f:
    json.dump(progress, f, indent=2)

print("Updated README & progress:", progress, "Latest:", latest)
