// ignore_for_file: prefer_const_constructors

import 'package:curved_navigation_bar/curved_navigation_bar.dart';
import 'package:flutter/material.dart';
import 'package:prepenem/screens/filtro.dart';
import 'package:prepenem/screens/lista_provas.dart';
import 'package:prepenem/screens/perfil.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  int index = 0;
  final screens = [Perfil(), Filtro(), ListaProvas()];

  @override
  Widget build(BuildContext context) {
    final items = <Widget>[
      Icon(Icons.person, size: 30),
      Icon(
        Icons.filter_alt,
        size: 30,
      ),
      Icon(
        Icons.list,
        size: 30,
      )
    ];
    return Container(
      color: Colors.green,
      child: SafeArea(
        top: false,
        child: Scaffold(
          body: screens[index],
          bottomNavigationBar: CurvedNavigationBar(
            color: Colors.green,
            backgroundColor: Colors.transparent,
            buttonBackgroundColor: Colors.transparent,
            items: items,
            index: index,
            height: 55,
            onTap: (index) => setState(() => this.index = index),
          ),
        ),
      ),
    );
  }
}
