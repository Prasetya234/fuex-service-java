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
<div>
    <table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
        <tr>
            <td bgcolor="#eaeaea" style="padding: 40px 30px 40px 30px;">
                <p style="color: black;">Hay ${username},</p><br/>
                <p style="color: black;">This is the email and password to login: </p>
                <div style="display: flex;">
                    <p style="font-size: 19px; padding: 0px 30px 0px 30px; text-direction: none; color: black;"><b>${email}</b></p><br/>
                    <p style="font-size: 19px; padding: 0px 10px 0px 10px;"><b>${password}</b></p><br/>
                </div>
                <!-- <p style="color: black; padding: 40px 0px 0px 0px; font-size: 20px; font-weight: bold;">Admin fuex</p> -->
            </td>
        </tr>
        <tr>
            <td bgcolor="#777777" style="padding: 30px 30px 30px 30px; align-items: center;">
                <p>@Excellent Semarang</p>
            </td>
        </tr>
    </table>
    <!-- START FOOTER -->
    <div class="footer" style="clear: both; Margin-top: 10px; text-align: center; width: 100%;">
        <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: separate; mso-table-lspace: 0pt; mso-table-rspace: 0pt; width: 100%;">
            <tr>
                <td class="content-block" style="font-family: sans-serif; vertical-align: top; padding-bottom: 10px; padding-top: 10px; font-size: 12px; color: #999999; text-align: center;">
                    <span class="apple-link" style="color: #999999; font-size: 12px; text-align: center;">Company Inc, Jl. Bulustalan I No.27, Kota Semarang, Jawa Tengah 50245</span>
                    <br /> visit our shop <a href="https://www.excellentcom.id/" style="text-decoration: underline; color: #999999; font-size: 12px; text-align: center;">Subscribe</a>.
                </td>
            </tr>
            <tr>
                <td class="content-block powered-by" style="font-family: sans-serif; vertical-align: top; padding-bottom: 10px; padding-top: 10px; font-size: 12px; color: #999999; text-align: center;">
                    Powered by <a href="http://htmlemail.io" style="color: #999999; font-size: 12px; text-align: center; text-decoration: none;">Spring Boot</a>.
                </td>
            </tr>
        </table>
    </div>
    <!-- END FOOTER -->
</div>
</body>
</html>