# Replace 'yourfile.txt' with the actual path to your file
$file = Get-Content -Path "C:\Users\highw\OneDrive\Desktop\Class\NOTES\Java\Advent of Code\Day 2\input.txt"

# Remove "Game #:" (where # is any whole positive integer)
$file = $file -replace '^Game \d+: '

# Save the modified content back to the file
$file | Set-Content -Path "C:\Users\highw\OneDrive\Desktop\Class\NOTES\Java\Advent of Code\input.txt"
