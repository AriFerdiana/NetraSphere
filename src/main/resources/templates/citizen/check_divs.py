
with open('c:/KULIAH/Daftar Tugas Semester 4/PBO/Tubes/src/main/resources/templates/citizen/dashboard.html', 'r', encoding='utf-8') as f:
    content = f.read()

open_divs = content.count('<div')
close_divs = content.count('</div')

print(f"Open divs: {open_divs}")
print(f"Close divs: {close_divs}")

# Check for specific tags
import re
tags = re.findall(r'<(div|/div)', content)
stack = []
for i, tag in enumerate(tags):
    if tag == 'div':
        stack.append(i)
    else:
        if stack:
            stack.pop()
        else:
            print(f"Extra closing div at index {i}")

if stack:
    print(f"Unclosed divs: {len(stack)}")
