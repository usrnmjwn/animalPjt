import chardet

with open("data/양서류.csv", "rb") as f:
    result = chardet.detect(f.read(10000))
    print(result)