#!/bin/bash

# Set the threshold for disk space (in percentage)
threshold=40
# Check disk space usage
disk_usage=$(df -h / | awk 'NR==2 {print $6}' | tr -d '%' | cut -d'C' -f1)
free_space=$(df -h / | awk 'NR==2 {print $5}' | tr -d '%' | cut -d'C' -f1)
echo "disk_usage: $disk_usage% | free_space: $free_space | date: `date`" >> ~/Desktop/UNIV/backup/logging/logs.txt

# Compare with the threshold
if [ "$disk_usage" -ge "$threshold" ]; then
    # Send alert/notification (replace with your notification mechanism)
    echo "Warning: Disk space usage is above $threshold%. Consider freeing up space." >> ~/Desktop/UNIV/backup/logging/logs.txt
    echo "-------------------------------------------------------------" >> ~/Desktop/UNIV/backup/logging/logs.txt
else
    echo "Disk space usage is within acceptable limits." >> ~/Desktop/UNIV/backup/logging/space_logs.txt 
    echo "-------------------------------------------------------------" >> ~/Desktop/UNIV/backup/logging/logs.txt
fi

