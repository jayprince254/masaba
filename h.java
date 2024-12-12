Imports System.Data.SqlClient

Public Class Form1
    ' Connection string to connect to MS SQL Server
    Dim connectionString As String = "Server=YOUR_SERVER_NAME;Database=YOUR_DATABASE_NAME;Trusted_Connection=True;"
    Dim connection As SqlConnection

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Try
            ' Initialize the connection
            connection = New SqlConnection(connectionString)
            connection.Open() ' Open the connection
            
            MessageBox.Show("Connection successful!", "Success", MessageBoxButtons.OK, MessageBoxIcon.Information)
            
            ' Call a method to fetch and display data
            LoadData()
        Catch ex As Exception
            MessageBox.Show("Error: " & ex.Message, "Connection Failed", MessageBoxButtons.OK, MessageBoxIcon.Error)
        Finally
            connection.Close() ' Always close the connection
        End Try
    End Sub

    Private Sub LoadData()
        Try
            ' SQL query to fetch data from a table
            Dim query As String = "SELECT * FROM YOUR_TABLE_NAME"
            Dim command As New SqlCommand(query, connection)

            ' Data adapter and data table to hold the results
            Dim adapter As New SqlDataAdapter(command)
            Dim table As New DataTable()
            adapter.Fill(table)

            ' Display data in DataGridView
            DataGridView1.DataSource = table
        Catch ex As Exception
            MessageBox.Show("Error loading data: " & ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
        End Try
    End Sub
End Class
