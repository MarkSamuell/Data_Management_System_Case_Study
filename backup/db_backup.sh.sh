#!/bin/bash

# Oracle Database Connection Details
DB_USER=SCHOOL
DB_PASSWORD=root
DB_SID=XE

# Absolute Backup Directory
BACKUP_DIR=~/Desktop/UNIV/backup

# Date Format for Backup File
DATE_FORMAT=$(date +"%Y%m%d_%H%M%S")

# Export File Name (only the file name, not the full path)
EXPORT_FILE="backup_${DATE_FORMAT}.dmp"

# Oracle Data Pump Export Command
expdp ${DB_USER}/${DB_PASSWORD}@${DB_SID} DIRECTORY=DATA_PUMP_DIR DUMPFILE=${EXPORT_FILE} FULL=Y

# Check if the export was successful
# if successful copy back file to your dir
if [ $? -eq 0 ]; then
    cp /c/oraclexe/app/oracle/admin/XE/dpdump/${EXPORT_FILE} ${BACKUP_DIR}/backup_files 
    echo "Database backup successful. | File: ${EXPORT_FILE} | date: `date` " >> ${BACKUP_DIR}/logging/logs.txt
    echo "-------------------------------------------------------------" >> ${BACKUP_DIR}/logging/logs.txt
else
    echo "Error: Database backup failed. | date: `date` " >> ${BACKUP_DIR}/logging/logs.txt
    echo "-------------------------------------------------------------" >> ${BACKUP_DIR}/logging/logs.txt
fi

