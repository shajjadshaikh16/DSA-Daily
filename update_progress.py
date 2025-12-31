import os, json
from datetime import date

categories = {
    "arrays": "Arrays",
    "strings": "Strings",
    "linked_list": "LinkedList",
    "trees": "Trees",
    "graphs": "Graphs",
    "dynamic_programming": "DynamicProgramming"
}

# load tracker
data = json.load(open("progress.json"))

# count java files in each folder
for key, folder in categories.items():
    path = os.path.join(folder)
    if os.path.isdir(path):
        count = len([f for f in os.listdir(path) if f.endswith(".java")])
        data[key] = count

data["total"] = sum(data[key] for key in categories.keys())

# write JSON back
json.dump(data, open("progress.json", "w"), indent=4)

# badges
badge = lambda text, count: f"![{text}](https://img.shields.io/badge/{text}-{count}-blue)"

summary = "\n".join([
    badge("Arrays", data["arrays"]),
    badge("Strings", data["strings"]),
    badge("LinkedList", data["linked_list"]),
    badge("Trees", data["trees"]),
    badge("Graphs", data["graphs"]),
    badge("DP", data["dynamic_programming"]),
    badge("Total", data["total"]).replace("blue", "green")
])

README = f"""
# 🚀 Java DSA Daily Practice Tracker

> Solving DSA problems consistently in Java — tracking mastery & progress.

## 📊 Progress Summary *(auto-updated)*
Last updated: **{date.today()}**

{summary}

### 🧠 How it updates
Every time I run:
python update_progress.py
git add .
git commit -m "progress update"
git push