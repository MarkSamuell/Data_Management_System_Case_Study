#!/bin/bash

# Oracle Database Connection Details
DB_USER=SCHOOL
DB_PASSWORD=root
DB_SID=XE

# Absolute Backup Directory
BACKUP_DIR=~/Desktop/UNIV/backup/logging

# Date Format for Backup File
DATE_FORMAT=$(date +"%Y%m%d_%H%M%S")

# Export File Name (only the file name, not the full path)
EXPORT_FILE="backup_${DATE_FORMAT}.dmp"

# Oracle Data Pump Export Command
expdp ${DB_USER}/${DB_PASSWORD}@${DB_SID} DIRECTORY=DATA_PUMP_DIR DUMPFILE=${EXPORT_FILE} FULL=Y

# Check if the export was successful
if [ $? -eq 0 ]; then
    echo "Database backup successful. | File: ${EXPORT_FILE} | date: `date` " >> ${BACKUP_DIR}/space_logs.txt
    echo "-------------------------------------------------------------" >> ${BACKUP_DIR}/space_logs.txt
else
    echo "Error: Database backup failed. | date: `date` " >> ${BACKUP_DIR}/space_logs.txt
    echo "-------------------------------------------------------------" >> ${BACKUP_DIR}/space_logs.txt
fi
