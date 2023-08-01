## Terraform

### IDE

Pick Pycharm over VS Code because it has a much better working plugin.  

### terraform-aws-modules/lambda

[RuntimeError: Python interpreter version equal to defined lambda runtime ...](https://github.com/terraform-aws-modules/terraform-aws-lambda/issues/452)

It is solved on Windows by using `mklink C:\D\Programs\Python3.10-helper-link\python3.10.exe C:\D\Programs\Python3.10\python.exe`.
If you create a `mklink` in the original Python folder you will get an error.  
