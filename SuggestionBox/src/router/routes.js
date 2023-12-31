
const routes = [
  {
    path: '/',
    component: () => import('layouts/MyLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Index.vue') },
    ],
  },
  {
    path: '/home',
    component: () => import('layouts/NavigationBar.vue'),
    children: [
      { path: '/dashboard', component: () => import('pages/Dashboard.vue') },
      { path: '/suggestion', component: () => import('pages/Suggestion.vue') },
      { path: '', component: () => import('pages/Dashboard.vue') },
      { path: '/create-user-account', component: () => import('pages/CreateUserAccount') },
    ],
  },
];

// Always leave this as last one
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue'),
  });
}

export default routes;
