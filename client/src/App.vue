<template>
  <v-app style = "background: #f5f5f5;">
    
    <v-app-bar style = "background: white;" app>
      <v-toolbar-title  class="headline text-uppercase" >
        <span class="font-weight-light">WELCOME</span>        
      </v-toolbar-title>
      
</v-app-bar>        
<br>
<br>
<br>
<br>
    <v-content>   
     
     
     
      <router-view/> 
    </v-content>
  </v-app>

</template>

<script>

export default {
  name: 'App',
  data: () => ({
    
  }),
};
</script>
