// ignore_for_file: prefer_const_constructors

import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:prepenem/screens/cadastro.dart';
import 'package:prepenem/screens/home.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:http/http.dart' as http;

class Login extends StatefulWidget {
  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  bool escondeSenha = true;
  TextEditingController emailController = TextEditingController();
  TextEditingController senhaController = TextEditingController();
  bool _carregando = false;

  signIn(String email, String senha) async {
    final String apiURL = "http://10.0.2.2:8080/token";
    final Uri uri = Uri.parse(apiURL);
    SharedPreferences sharedPreferences = await SharedPreferences.getInstance();
    Map body = {"email": email, "senha": senha};
    var jsonResponse;
    var res = await http.post(uri, body: body);
    if (res.statusCode == 200) {
      jsonResponse = jsonDecode(res.body);
      print("Response status: ${res.statusCode}");
      print("Response status: ${res.body}");
      if (jsonResponse != null) {
        setState(() {
          _carregando = false;
        });
        sharedPreferences.setString("token", jsonResponse['token']);
        Navigator.of(context).pushAndRemoveUntil(
            MaterialPageRoute(builder: (BuildContext context) => Home()),
            (Route<dynamic> route) => false);
      }
    } else {
      setState(() {
        _carregando = false;
      });
      print("Response status: ${res.body}");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // ignore: avoid_unnecessary_containers
      body: Container(
        child: SingleChildScrollView(
            child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                'Bem-vindo ao',
                textScaleFactor: 1,
                style: TextStyle(
                    fontFamily: 'Montserrat',
                    fontSize: 28.0,
                    fontWeight: FontWeight.w700,
                    color: Color.fromARGB(255, 41, 43, 35),
                    height: 7),
              ),
              Text('PrepENEM',
                  textScaleFactor: 1,
                  style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 28.0,
                      fontWeight: FontWeight.w700,
                      color: Color.fromARGB(255, 41, 43, 35),
                      height: 0)),
              Text('Já possui cadastro?',
                  textScaleFactor: 1,
                  style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 23.0,
                      fontWeight: FontWeight.w700,
                      color: Color.fromARGB(255, 41, 43, 35),
                      height: 5)),
              Padding(
                padding: EdgeInsets.fromLTRB(40, 0, 40, 0),
                child: TextFormField(
                  controller: emailController,
                  textAlign: TextAlign.left,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    hintText: 'E-mail:',
                  ),
                ),
              ),
              Padding(
                padding: EdgeInsets.fromLTRB(40, 20, 40, 20),
                child: TextFormField(
                  controller: senhaController,
                  obscureText: escondeSenha,
                  textAlign: TextAlign.left,
                  decoration: InputDecoration(
                      border: OutlineInputBorder(),
                      hintText: 'Senha:',
                      suffixIcon: IconButton(
                          onPressed: () {
                            setState(() {
                              escondeSenha = !escondeSenha;
                            });
                          },
                          color: Theme.of(context).accentColor.withOpacity(0.4),
                          icon: Icon(escondeSenha
                              ? Icons.visibility_off
                              : Icons.visibility))),
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(bottom: 20),
                child: SizedBox(
                  width: 290,
                  child: ElevatedButton(
                      onPressed: emailController.text == "" ||
                              senhaController.text == ""
                          ? null
                          : () {
                              setState(() {
                                _carregando = true;
                              });
                              signIn(
                                  emailController.text, senhaController.text);
                            },
                      style: ButtonStyle(
                          backgroundColor: MaterialStateProperty.all<Color>(
                              Color(0xff40FD48))),
                      child: Text(
                        'Continuar',
                        style: TextStyle(
                            fontFamily: 'Montserrat',
                            fontSize: 17.0,
                            fontWeight: FontWeight.w900,
                            color: Color.fromARGB(255, 62, 66, 55)),
                      )),
                ),
              ),
              Text('Ainda não possui cadastro?',
                  textScaleFactor: 1,
                  style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 23.0,
                      fontWeight: FontWeight.w700,
                      color: Color.fromARGB(255, 41, 43, 35),
                      height: 1.9)),
              Text('Vamos resolver isso!',
                  textScaleFactor: 1,
                  style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 23.0,
                      fontWeight: FontWeight.w700,
                      color: Color.fromARGB(255, 41, 43, 35),
                      height: 1.2)),
              Padding(
                padding: const EdgeInsets.only(top: 27),
                child: SizedBox(
                  width: 290,
                  child: ElevatedButton(
                      onPressed: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => Cadastro()));
                      },
                      style: ButtonStyle(
                          backgroundColor: MaterialStateProperty.all<Color>(
                              Color(0xff40FD48))),
                      child: Text(
                        'Cadastrar',
                        style: TextStyle(
                            fontFamily: 'Montserrat',
                            fontSize: 17.0,
                            fontWeight: FontWeight.w900,
                            color: Color.fromARGB(255, 62, 66, 55)),
                      )),
                ),
              ),
            ],
          ),
        )),
      ),
    );
  }
}
