import os
import subprocess

def format_problem_name(filename):
    name = filename.split(".")[0]
    cleaned = re.sub(r'^\d+', '', name).lstrip('_')
    cleaned = cleaned.replace('_', ' ').title()
    return cleaned

files = [f for f in os.listdir(".") if f.endswith(".java")]
if not files:
    print("No Java files found.")
    exit()

latest = max(files, key=os.path.getctime)
msg = f"Solved: {format_problem_name(latest)}"
print("Commit message:", msg)

subprocess.run(["git","add","."])
subprocess.run(["git","commit","-m", msg])
