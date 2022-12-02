operations = ['+', '-', '*', '//']
equations = {}
for i in range(4):
    for j in range(4):
        for k in range(4):
            expression = "4 " + operations[i] + " 4 " + operations[j] + " 4 " + operations[k] + " 4"
            value = eval(expression)
            equations[value] = expression

cases = int(input())
for _ in range(cases):
    target = int(input())
    if target in equations:
        print(equations[target].replace('//', '/') + " = " + str(target))
    else:
        print('no solution')
