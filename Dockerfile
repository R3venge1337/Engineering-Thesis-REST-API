# Use the official SQL Server 2019 image from Microsoft
FROM mcr.microsoft.com/mssql/server:2019-latest

# Set environment variables for SQL Server
ENV ACCEPT_EULA=Y
ENV SA_PASSWORD=YourStrongPassword!

# Enable FileStream and configure the instance
RUN /opt/mssql/bin/sqlservr-setup -q -x

# Start SQL Server when the container starts
CMD ["/opt/mssql/bin/sqlservr"]

# Create the FileStream data directory
RUN mkdir /var/opt/mssql/filestream_data
RUN chown -R mssql:mssql /var/opt/mssql/filestream_data

# Copy the database script to the container
COPY create_database.sql /create_database.sql

# Expose the SQL Server port
EXPOSE 1433