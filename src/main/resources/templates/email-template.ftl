<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sending Email with Freemarker HTML Template Example</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css' />
    <!-- use the font -->
    <style type="css">
        body {
            font-family: 'Roboto', sans-serif;
            font-size: 48px;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">
<table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
    <tr>
        <td bgcolor="#eaeaea" style="padding: 40px 30px 40px 30px;">
            <p>Dear ${username},</p>
            <p>Your account has been sign up on fuex</p><br/>
            <p>Thanks</p>
            <p><a href="https://fuex-service.herokuapp.com/user/access/${id}">Accounts Verify To Login</a></p>
        </td>
    </tr>
    <tr>
        <td bgcolor="#777777" style="padding: 30px 30px 30px 30px; align-items: center;">
            <p>@Company of Excellent Semarang</p>
        </td>
    </tr>
</table>
</body>
</html>