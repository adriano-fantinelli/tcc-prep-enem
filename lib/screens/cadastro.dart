// ignore_for_file: prefer_const_constructors, prefer_const_declarations

import 'package:flutter/material.dart';
import 'package:prepenem/model/usuario_model.dart';
import 'package:prepenem/screens/login.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class Cadastro extends StatefulWidget {
  const Cadastro({Key? key}) : super(key: key);

  @override
  State<Cadastro> createState() => _CadastroState();
}

Future<UsuarioModel> criaUsuario(String email, String senha, String nome,
    String telefone, String descricao, bool professor) async {
  final String apiURL = "http://10.0.2.2:8080/usuarios";
  final Uri uri = Uri.parse(apiURL);
  final response = await http.post(uri,
      headers: {"Content-type": "application/json"},
      body: json.encode({
        "email": email,
        "senha": senha,
        "nome": nome,
        "descricao": descricao,
        "numeroCelular": telefone,
        "professor": professor
      }));
  if (response.statusCode == 200) {
    final String responseBody = response.body;
    return usuarioModelFromJson(responseBody);
  } else {
    final String responseString = response.body;
    return usuarioModelFromJson(responseString);
  }
}

class _CadastroState extends State<Cadastro> {
  bool escondeSenha = true;
  bool? professor = false;
  final TextEditingController emailController = TextEditingController();
  final TextEditingController senhaController = TextEditingController();
  final TextEditingController nomeController = TextEditingController();
  final TextEditingController telefoneController = TextEditingController();
  final TextEditingController descricaoController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: SingleChildScrollView(
          child: Center(
            child:
                // ignore: prefer_const_literals_to_create_immutables
                Column(mainAxisAlignment: MainAxisAlignment.center, children: [
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
              Text('Precisamos apenas de',
                  textScaleFactor: 1,
                  style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 23.0,
                      fontWeight: FontWeight.w700,
                      color: Color.fromARGB(255, 41, 43, 35),
                      height: 3.1)),
              Text('algumas informações para',
                  textScaleFactor: 1,
                  style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 23.0,
                      fontWeight: FontWeight.w700,
                      color: Color.fromARGB(255, 41, 43, 35),
                      height: 1.4)),
              Text('concluir seu cadastro',
                  textScaleFactor: 1,
                  style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 23.0,
                      fontWeight: FontWeight.w700,
                      color: Color.fromARGB(255, 41, 43, 35),
                      height: 1.8)),
              Padding(
                padding: EdgeInsets.fromLTRB(40, 15, 40, 0),
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
                padding: EdgeInsets.fromLTRB(40, 15, 40, 0),
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
                padding: EdgeInsets.fromLTRB(40, 15, 40, 0),
                child: TextFormField(
                  controller: nomeController,
                  textAlign: TextAlign.left,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    hintText: 'Nome:',
                  ),
                ),
              ),
              Padding(
                padding: EdgeInsets.fromLTRB(40, 15, 40, 0),
                child: TextFormField(
                  controller: telefoneController,
                  textAlign: TextAlign.left,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    hintText: 'Telefone:',
                  ),
                ),
              ),
              Padding(
                padding: EdgeInsets.fromLTRB(40, 15, 40, 20),
                child: TextFormField(
                  controller: descricaoController,
                  textAlign: TextAlign.left,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    hintText: 'Descrição:',
                  ),
                ),
              ),
              CheckboxListTile(
                title: Text('Eu sou um professor',
                    textScaleFactor: 1,
                    style: TextStyle(
                        fontFamily: 'Montserrat',
                        fontSize: 21.0,
                        fontWeight: FontWeight.w700,
                        color: Color.fromARGB(255, 41, 43, 35),
                        height: 1.1)),
                value: professor,
                onChanged: (bool? valor) {
                  setState(() {
                    professor = valor;
                  });
                },
                contentPadding: EdgeInsets.fromLTRB(42, 0, 99, 0),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 13, bottom: 20),
                child: SizedBox(
                  width: 290,
                  child: ElevatedButton(
                      onPressed: () async {
                        String email = emailController.text;
                        String senha = senhaController.text;
                        String nome = nomeController.text;
                        String telefone = telefoneController.text;
                        String descricao = descricaoController.text;

                        final UsuarioModel usuario = await criaUsuario(email,
                            senha, nome, telefone, descricao, professor!);

                        Navigator.push(context,
                            MaterialPageRoute(builder: (context) => Login()));
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
            ]),
          ),
        ),
      ),
    );
  }
}
