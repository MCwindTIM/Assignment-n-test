Public Class From
    Dim Path = Application.StartupPath() & "\Record\"
    Dim RecordAmount As Integer = 0
    Dim Test_P As Double = 0.5
    Dim Quiz_P As Double = 0.2
    Dim Project_P As Double = 0.3
    Dim CA_P As Double = 0.4
    Dim Exam_P As Double = 0.6
    Private Sub btn_clear_Click(sender As Object, e As EventArgs) Handles btn_clear.Click
        txt_name.Clear()
        txt_test.Clear()
        txt_quizzes.Clear()
        txt_project.Clear()
        txt_exam.Clear()
        txt_ca_marks.Clear()
        txt_module_marks.Clear()
        txt_remarks.Clear()
        txt_module_grade.Clear()
        MessageBox.Show("All textboxes in the group-box [Marks and Grade for Individual Student] have been clear!")
    End Sub

    Private Sub From_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        MessageBox.Show("Recommend running this program as Administrator!!!", "Hello There!!!")
        txt_save.Text = Path
        lbl_onload_CA.Text = "Test: " & Test_P * 100 & "% " & "Quiz: " & Quiz_P * 100 & "% " & "Project: " & Project_P * 100 & "%"
            lbl_onload_MR.Text = "(CA: " & CA_P * 100 & "% " & "Exam: " & Exam_P * 100 & "%)"

            Dim Record = Dir$(Path)
        Dim cleanRec As String
        Do While Len(Record) > 0
            If Record <> ".." Then
                cleanRec = Replace(Record, ".txt", "")
                Box_lstRecord.Items.Add(cleanRec)
                Record = Dir$()
            End If
        Loop
    End Sub

    Private Sub btn_confirm_Click(sender As Object, e As EventArgs) Handles btn_confirm.Click
        ' Check Input for Text Box (txt.name)
        If txt_name.Text = "" Then
            MessageBox.Show("Please input Student name", "*Error Message*")
        Else
            Dim nInput As String = txt_name.Text
            Dim lastLetter As Char = nInput.Last
            If lastLetter = " " Then
                txt_name.Text = Mid(txt_name.Text, 1, Len(txt_name.Text) - 1)
            End If

        End If

        ' textbox last char cannot be " " (space)
        ' Check Marks vaild or not
        If txt_test.Text = "" Then
            MessageBox.Show("Please don't leave me alone! Input something! [Test]", "*Error Message*")
        Else
            If CDbl(txt_test.Text) >= 0 And CDbl(txt_test.Text) <= 100 Then
                If txt_quizzes.Text = "" Then
                    MessageBox.Show("Please don't leave me alone! Input something! [Quizzes]", "*Error Message*")
                Else
                    If CDbl(txt_quizzes.Text) >= 0 And CDbl(txt_quizzes.Text) <= 100 Then
                        If txt_project.Text = "" Then
                            MessageBox.Show("Please don't leave me alone! Input something! [Project]", "*Error Message*")
                        Else
                            If CDbl(txt_project.Text) >= 0 And CDbl(txt_project.Text) <= 100 Then
                                If txt_exam.Text = "" Then
                                    MessageBox.Show("Please don't leave me alone! Input something! [Exam]", "*Error Message*")
                                Else
                                    If CDbl(txt_exam.Text) >= 0 And CDbl(txt_exam.Text) <= 100 Then
                                        txt_ca_marks.Text = CDbl(txt_test.Text) * Test_P + CDbl(txt_project.Text) * Project_P + CDbl(txt_quizzes.Text) * Quiz_P
                                        txt_module_marks.Text = CDbl(txt_ca_marks.Text) * CA_P + CDbl(txt_exam.Text) * Exam_P

                                        If CDbl(txt_ca_marks.Text) < 40 Or CDbl(txt_exam.Text) < 40 Then
                                            txt_module_grade.Text = "F"
                                            If CDbl(txt_module_marks.Text) >= 30 Then
                                                txt_remarks.Text = "Resit Exam"
                                                If Box_lstRecord.Items.Contains(txt_name.Text) Then
                                                    MessageBox.Show("Already have this student's record")
                                                Else
                                                    Box_lstRecord.Items.Add(txt_name.Text)
                                                    Dim file As System.IO.StreamWriter
                                                    If (Not System.IO.Directory.Exists(Path)) Then
                                                        System.IO.Directory.CreateDirectory(Path)
                                                    End If
                                                    file = My.Computer.FileSystem.OpenTextFileWriter(Path & txt_name.Text & ".txt", True)
                                                    file.WriteLine("*****Student name*****")
                                                    file.WriteLine(txt_name.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("******Test Marks******")
                                                    file.WriteLine(txt_test.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("****Quizzes Marks*****")
                                                    file.WriteLine(txt_quizzes.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("****Project Marks*****")
                                                    file.WriteLine(txt_project.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("******Exam Marks******")
                                                    file.WriteLine(txt_exam.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("*******Ca Marks*******")
                                                    file.WriteLine(txt_ca_marks.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("****Module Marks******")
                                                    file.WriteLine(txt_module_marks.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("*****Module Grade*****")
                                                    file.WriteLine(txt_module_grade.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("*******Remarks********")
                                                    file.WriteLine(txt_remarks.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("Record Save at: " & DateTime.Now.ToString())
                                                    file.Close()
                                                End If
                                            Else
                                                If CDbl(txt_module_marks.Text) < 30 Then
                                                    txt_remarks.Text = "Restudy"
                                                    If Box_lstRecord.Items.Contains(txt_name.Text) Then
                                                        MessageBox.Show("Already have this student's record")
                                                    Else
                                                        Box_lstRecord.Items.Add(txt_name.Text)
                                                        Dim file As System.IO.StreamWriter
                                                        If (Not System.IO.Directory.Exists(Path)) Then
                                                            System.IO.Directory.CreateDirectory(Path)
                                                        End If
                                                        file = My.Computer.FileSystem.OpenTextFileWriter(Path & txt_name.Text & ".txt", True)
                                                        file.WriteLine("*****Student name*****")
                                                        file.WriteLine(txt_name.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("******Test Marks******")
                                                        file.WriteLine(txt_test.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("****Quizzes Marks*****")
                                                        file.WriteLine(txt_quizzes.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("****Project Marks*****")
                                                        file.WriteLine(txt_project.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("******Exam Marks******")
                                                        file.WriteLine(txt_exam.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("*******Ca Marks*******")
                                                        file.WriteLine(txt_ca_marks.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("****Module Marks******")
                                                        file.WriteLine(txt_module_marks.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("*****Module Grade*****")
                                                        file.WriteLine(txt_module_grade.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("*******Remarks********")
                                                        file.WriteLine(txt_remarks.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("Record Save at: " & DateTime.Now.ToString())
                                                        file.Close()
                                                    End If
                                                End If
                                            End If
                                        Else
                                            If CDbl(txt_module_marks.Text) >= 75 And CDbl(txt_module_marks.Text) <= 100 Then
                                                txt_module_grade.Text = "A"
                                                txt_remarks.Text = "Pass"
                                                If Box_lstRecord.Items.Contains(txt_name.Text) Then
                                                    MessageBox.Show("Already have this student's record")
                                                Else
                                                    Box_lstRecord.Items.Add(txt_name.Text)
                                                    Dim file As System.IO.StreamWriter
                                                    If (Not System.IO.Directory.Exists(Path)) Then
                                                        System.IO.Directory.CreateDirectory(Path)
                                                    End If
                                                    file = My.Computer.FileSystem.OpenTextFileWriter(Path & txt_name.Text & ".txt", True)
                                                    file.WriteLine("*****Student name*****")
                                                    file.WriteLine(txt_name.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("******Test Marks******")
                                                    file.WriteLine(txt_test.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("****Quizzes Marks*****")
                                                    file.WriteLine(txt_quizzes.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("****Project Marks*****")
                                                    file.WriteLine(txt_project.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("******Exam Marks******")
                                                    file.WriteLine(txt_exam.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("*******Ca Marks*******")
                                                    file.WriteLine(txt_ca_marks.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("****Module Marks******")
                                                    file.WriteLine(txt_module_marks.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("*****Module Grade*****")
                                                    file.WriteLine(txt_module_grade.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("*******Remarks********")
                                                    file.WriteLine(txt_remarks.Text)
                                                    file.WriteLine("**********************")
                                                    file.WriteLine("")
                                                    file.WriteLine("Record Save at: " & DateTime.Now.ToString())
                                                    file.Close()
                                                End If
                                            Else
                                                If CDbl(txt_module_marks.Text) < 75 And CDbl(txt_module_marks.Text) >= 65 Then
                                                    txt_module_grade.Text = "B"
                                                    txt_remarks.Text = "Pass"
                                                    If Box_lstRecord.Items.Contains(txt_name.Text) Then
                                                        MessageBox.Show("Already have this student's record")
                                                    Else
                                                        Box_lstRecord.Items.Add(txt_name.Text)
                                                        Dim file As System.IO.StreamWriter
                                                        If (Not System.IO.Directory.Exists(Path)) Then
                                                            System.IO.Directory.CreateDirectory(Path)
                                                        End If
                                                        file = My.Computer.FileSystem.OpenTextFileWriter(Path & txt_name.Text & ".txt", True)
                                                        file.WriteLine("*****Student name*****")
                                                        file.WriteLine(txt_name.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("******Test Marks******")
                                                        file.WriteLine(txt_test.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("****Quizzes Marks*****")
                                                        file.WriteLine(txt_quizzes.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("****Project Marks*****")
                                                        file.WriteLine(txt_project.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("******Exam Marks******")
                                                        file.WriteLine(txt_exam.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("*******Ca Marks*******")
                                                        file.WriteLine(txt_ca_marks.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("****Module Marks******")
                                                        file.WriteLine(txt_module_marks.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("*****Module Grade*****")
                                                        file.WriteLine(txt_module_grade.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("*******Remarks********")
                                                        file.WriteLine(txt_remarks.Text)
                                                        file.WriteLine("**********************")
                                                        file.WriteLine("")
                                                        file.WriteLine("Record Save at: " & DateTime.Now.ToString())
                                                        file.Close()
                                                    End If
                                                Else
                                                    If CDbl(txt_module_marks.Text) < 65 And CDbl(txt_module_marks.Text) >= 40 Then
                                                        txt_module_grade.Text = "C"
                                                        txt_remarks.Text = "Pass"
                                                        If Box_lstRecord.Items.Contains(txt_name.Text) Then
                                                            MessageBox.Show("Already have this student's record")
                                                        Else
                                                            Box_lstRecord.Items.Add(txt_name.Text)
                                                            Dim file As System.IO.StreamWriter
                                                            If (Not System.IO.Directory.Exists(Path)) Then
                                                                System.IO.Directory.CreateDirectory(Path)
                                                            End If
                                                            file = My.Computer.FileSystem.OpenTextFileWriter(Path & txt_name.Text & ".txt", True)
                                                            file.WriteLine("*****Student name*****")
                                                            file.WriteLine(txt_name.Text)
                                                            file.WriteLine("**********************")
                                                            file.WriteLine("")
                                                            file.WriteLine("******Test Marks******")
                                                            file.WriteLine(txt_test.Text)
                                                            file.WriteLine("**********************")
                                                            file.WriteLine("")
                                                            file.WriteLine("****Quizzes Marks*****")
                                                            file.WriteLine(txt_quizzes.Text)
                                                            file.WriteLine("**********************")
                                                            file.WriteLine("")
                                                            file.WriteLine("****Project Marks*****")
                                                            file.WriteLine(txt_project.Text)
                                                            file.WriteLine("**********************")
                                                            file.WriteLine("")
                                                            file.WriteLine("******Exam Marks******")
                                                            file.WriteLine(txt_exam.Text)
                                                            file.WriteLine("**********************")
                                                            file.WriteLine("")
                                                            file.WriteLine("*******Ca Marks*******")
                                                            file.WriteLine(txt_ca_marks.Text)
                                                            file.WriteLine("**********************")
                                                            file.WriteLine("")
                                                            file.WriteLine("****Module Marks******")
                                                            file.WriteLine(txt_module_marks.Text)
                                                            file.WriteLine("**********************")
                                                            file.WriteLine("")
                                                            file.WriteLine("*****Module Grade*****")
                                                            file.WriteLine(txt_module_grade.Text)
                                                            file.WriteLine("**********************")
                                                            file.WriteLine("")
                                                            file.WriteLine("*******Remarks********")
                                                            file.WriteLine(txt_remarks.Text)
                                                            file.WriteLine("**********************")
                                                            file.WriteLine("")
                                                            file.WriteLine("Record Save at: " & DateTime.Now.ToString())
                                                            file.Close()
                                                        End If
                                                    Else
                                                    End If
                                                End If
                                            End If
                                        End If
                                    Else
                                        MessageBox.Show("Please input a vaild exam Marks", "*Error Message*")
                                        txt_exam.Clear()
                                    End If
                                End If
                            Else
                                MessageBox.Show("Please input a vaild Project Marks", "*Error Message*")
                                txt_project.Clear()

                            End If
                        End If


                    Else
                        MessageBox.Show("Please input a vaild Quzzies Marks", "*Error Message*")
                        txt_quizzes.Clear()
                    End If
                End If
            Else
                MessageBox.Show("Please input a vaild Test Marks", "*Error Message*")
                txt_test.Clear()
            End If
        End If
    End Sub

    Private Sub txt_test_KeyPress(sender As Object, e As KeyPressEventArgs) Handles txt_test.KeyPress
        If Asc(e.KeyChar) <> 8 Then
            If Asc(e.KeyChar) < 48 Or Asc(e.KeyChar) > 57 Then
                e.Handled = True
            End If
        End If
    End Sub

    Private Sub txt_quizzes_KeyPress(sender As Object, e As KeyPressEventArgs) Handles txt_quizzes.KeyPress
        If Asc(e.KeyChar) <> 8 Then
            If Asc(e.KeyChar) < 48 Or Asc(e.KeyChar) > 57 Then
                e.Handled = True
            End If
        End If
    End Sub

    Private Sub txt_project_KeyPress(sender As Object, e As KeyPressEventArgs) Handles txt_project.KeyPress
        If Asc(e.KeyChar) <> 8 Then
            If Asc(e.KeyChar) < 48 Or Asc(e.KeyChar) > 57 Then
                e.Handled = True
            End If
        End If
    End Sub

    Private Sub txt_exam_KeyPress(sender As Object, e As KeyPressEventArgs) Handles txt_exam.KeyPress
        If Asc(e.KeyChar) <> 8 Then
            If Asc(e.KeyChar) < 48 Or Asc(e.KeyChar) > 57 Then
                e.Handled = True
            End If
        End If
    End Sub

    Private Sub txt_name_KeyPress(sender As Object, e As KeyPressEventArgs) Handles txt_name.KeyPress
        If Not (Asc(e.KeyChar) = 8) Then
            Dim allowedChars As String = "abcdefghijklmnopqrstuvwxyz" & " "
            If Not allowedChars.Contains(e.KeyChar.ToString.ToLower) Then
                e.KeyChar = ChrW(0)
                e.Handled = True
            End If
        End If
        Dim _string As String = txt_name.Text
        If _string = " " Then
            txt_name.Text = ""
        End If
    End Sub

    Private Sub btn_open_Click(sender As Object, e As EventArgs) Handles btn_open.Click
        Dim target = txt_find.Text
        Dim targetsel = Box_lstRecord.SelectedItem
        Dim FILE_NAMEText As String = Path & target & ".txt"
        Dim FILE_NAMESEL As String = Path & targetsel & ".txt"
        If System.IO.File.Exists(FILE_NAMEText) = True Then
            Process.Start(FILE_NAMEText)
            txt_find.Clear()
        Else
            If System.IO.File.Exists(FILE_NAMESEL) = True Then
                Process.Start(FILE_NAMESEL)
            Else
                MessageBox.Show("Please Select record or input the vaild student name in textbox!")
            End If
        End If
    End Sub

    Private Sub btn_find_Click(sender As Object, e As EventArgs) Handles btn_find.Click
        Dim found As Boolean = False
        Dim Target = txt_find.Text
        If Target = "" Then
            MessageBox.Show("Please enter Student Name!")
        Else
            For i As Integer = 0 To Box_lstRecord.Items.Count() - 1
                If (Box_lstRecord.Items(i) = Target) Then
                    MsgBox(Target & " is on line " & i + 1 & " of the list.")
                    found = True
                    Exit For
                    txt_find.Clear()
                End If
            Next
            If (found = False) Then
                MsgBox("Student not found")
            End If
        End If
    End Sub

    Private Sub btn_del_Click(sender As Object, e As EventArgs) Handles btn_del.Click
        Dim targetsel = Box_lstRecord.SelectedItem
        Dim target = txt_find.Text
        Dim FILE_NAMESEL As String = Path & targetsel & ".txt"
        Dim FILE_NAMEText As String = Path & target & ".txt"
        Dim Confirm As Integer = MessageBox.Show("Are you confirm to delete selected record?", "Warning", MessageBoxButtons.YesNo)
        If Confirm = DialogResult.No Then
        ElseIf Confirm = DialogResult.Yes Then
            If System.IO.File.Exists(FILE_NAMEText) = True Then
                Box_lstRecord.Items.Remove(target)
                My.Computer.FileSystem.DeleteFile(FILE_NAMEText)
                MessageBox.Show(target & "'s record deleted!")
                txt_find.Clear()
                Box_lstRecord.SelectedIndex = 0
            ElseIf System.IO.File.Exists(FILE_NAMESEL) = True Then
                Box_lstRecord.Items.Remove(targetsel)
                My.Computer.FileSystem.DeleteFile(FILE_NAMESEL)
                MessageBox.Show(targetsel & "'s record deleted!")
                If Box_lstRecord.Items.Count = 0 Then
                Else
                    Box_lstRecord.SelectedIndex = 0
                End If
            Else
                MessageBox.Show("Please select redcord or input the vaild student name in textbox!")
            End If
        End If
    End Sub

    Private Sub btn_del_all_Click(sender As Object, e As EventArgs) Handles btn_del_all.Click
        Dim Confirm As Integer = MessageBox.Show("Are you confirm to delete all record?", "Warning", MessageBoxButtons.YesNoCancel)
        If Confirm = DialogResult.Cancel Then
        ElseIf Confirm = DialogResult.No Then
        ElseIf Confirm = DialogResult.Yes Then
            System.IO.Directory.Delete(Path, True)
            Box_lstRecord.Items.Clear()
            MessageBox.Show("All Record Deleted!")
        End If
    End Sub

    Private Sub btn_show_Click(sender As Object, e As EventArgs) Handles btn_show.Click
        If (Not System.IO.Directory.Exists(Path)) Then
            System.IO.Directory.CreateDirectory(Path)
        End If
        RecordAmount = IO.Directory.GetFiles(Path, "*.txt").Length
        If RecordAmount = 0 Then
            MessageBox.Show("Not have any record yet!")
            txt_number_of_students.Text = 0
        Else
            txt_number_of_students.Text = RecordAmount
        End If
        Dim RecordA = Dir$(Path)
        Dim A As Integer = 0
        Do While Len(RecordA) > 0
            If RecordA <> ".." Then
                Dim RecordDirA As String = Path & RecordA
                Dim CounterA As String = System.IO.File.ReadAllLines(RecordDirA)(29)
                If CounterA = "A" Then
                    A += 1
                End If
                RecordA = Dir$()
            End If
        Loop
        txt_count_of_A.Text = A
        Dim RecordF = Dir$(Path)
        Dim F As Integer = 0
        Do While Len(RecordF) > 0
            If RecordF <> ".." Then
                Dim RecordDirF As String = Path & RecordF
                Dim CounterF As String = System.IO.File.ReadAllLines(RecordDirF)(29)
                If CounterF = "F" Then
                    F += 1
                End If
                RecordF = Dir$()
            End If
        Loop
        txt_count_of_f.Text = F
        Dim RecordAve = Dir$(Path)
        Dim FileAmount As Integer = 0
        Dim Ave As Double = 0
        Do While Len(RecordAve) > 0
            If RecordAve <> ".." Then
                Dim RecordDirAve As String = Path & RecordAve
                Dim CounterAve As String = System.IO.File.ReadAllLines(RecordDirAve)(25)
                Ave += CounterAve
                FileAmount += 1
                RecordAve = Dir$()
            End If
        Loop
        If FileAmount = 0 Then
            txt_module_average.Text = 0
        Else
            txt_module_average.Text = Ave / FileAmount
        End If

    End Sub

    Private Sub From_MouseMove(sender As Object, e As MouseEventArgs) Handles MyBase.MouseMove
        Dim RecInvaild As String = Path + ".txt"
        If System.IO.File.Exists(RecInvaild) Then
            System.IO.File.Delete(Path & ".txt")
            Box_lstRecord.Items.Remove("")
        Else
        End If
    End Sub

    Private Sub txt_name_KeyDown(sender As Object, e As KeyEventArgs) Handles txt_name.KeyDown
        If e.KeyCode = Keys.Enter Then
            Call btn_confirm_Click(sender, e)
        End If
    End Sub

    Private Sub txt_test_KeyDown(sender As Object, e As KeyEventArgs) Handles txt_test.KeyDown
        If e.KeyCode = Keys.Enter Then
            Call btn_confirm_Click(sender, e)
        End If
    End Sub

    Private Sub txt_quizzes_KeyDown(sender As Object, e As KeyEventArgs) Handles txt_quizzes.KeyDown
        If e.KeyCode = Keys.Enter Then
            Call btn_confirm_Click(sender, e)
        End If
    End Sub

    Private Sub txt_project_KeyDown(sender As Object, e As KeyEventArgs) Handles txt_project.KeyDown
        If e.KeyCode = Keys.Enter Then
            Call btn_confirm_Click(sender, e)
        End If
    End Sub

    Private Sub txt_exam_KeyDown(sender As Object, e As KeyEventArgs) Handles txt_exam.KeyDown
        If e.KeyCode = Keys.Enter Then
            Call btn_confirm_Click(sender, e)
        End If
    End Sub

    Private Sub From_FormClosing(sender As Object, e As FormClosingEventArgs) Handles MyBase.FormClosing
        Dim Confirm As Integer = MessageBox.Show("Are you want to exit now ?", "Are you want to exit ?", MessageBoxButtons.YesNo)
        If Confirm = DialogResult.No Then
            e.Cancel = True
        ElseIf Confirm = DialogResult.Yes Then
        End If
    End Sub

    Private Sub btn_save_Click(sender As Object, e As EventArgs) Handles btn_save.Click
        If (Not System.IO.Directory.Exists(Path)) Then
            System.IO.Directory.CreateDirectory(Path)
        End If
        Process.Start("Explorer.exe", Path)
    End Sub
End Class