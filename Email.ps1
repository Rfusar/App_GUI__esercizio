param (
    [string]$ParametroJson
)

$EMAIL = $ParametroJson | ConvertFrom-Json


if ($EMAIL -ne $null) {
    $oggetto = $EMAIL.oggetto
    $corpo = $EMAIL.body 
    $aChi = $EMAIL.emailDestinatario
    $myEmail = $EMAIL.emailUtente
    $file = $EMAIL.file
    $p = $EMAIL.password_GMAIL

    if ($file -eq ""){
        $SMTP = "smtp.gmail.com"
        $From = $myEmail
        $To = $aChi
        $Subject = $oggetto
        $Body = $corpo

        $Email = New-Object Net.Mail.SmtpClient($SMTP, 587)
        $Email.EnableSsl = $true

        $MailMessage = New-Object Net.Mail.MailMessage
        $MailMessage.From = $From
        $MailMessage.To.Add($To)
        $MailMessage.Subject = $Subject
        $MailMessage.Body = $Body

        $Email.Credentials = New-Object System.Net.NetworkCredential($myEmail, $p)

        $Email.Send($MailMessage)
        Write-Host "`n`nfatto"
    }
    else{
        $SMTP = "smtp.gmail.com"
        $From = $myEmail
        $To = $aChi
        $Subject = $oggetto
        $Body = $corpo
        $AttachmentPath = $file

        $Email = New-Object Net.Mail.SmtpClient($SMTP, 587)
        $Email.EnableSsl = $true

        $MailMessage = New-Object Net.Mail.MailMessage
        $MailMessage.From = $From
        $MailMessage.To.Add($To)
        $MailMessage.Subject = $Subject
        $MailMessage.Body = $Body

        # Allega il file
        $Attachment = New-Object Net.Mail.Attachment($AttachmentPath)
        $MailMessage.Attachments.Add($Attachment)

        $Email.Credentials = New-Object System.Net.NetworkCredential($myEmail, $p)

        $Email.Send($MailMessage)

        # Chiudi l'oggetto Attachment
        $Attachment.Dispose()

        Write-Host "`n`nfatto"
    }

} else {Write-Host "errore da powershell"}

